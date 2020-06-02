package com.pdmweb.pdm.service.impl;

import com.pdmweb.base.data.BaseTables;
import com.pdmweb.base.jooq.tables.records.PdmListRecord;
import com.pdmweb.base.jooq.tables.records.PdmTableFieldRecord;
import com.pdmweb.base.jooq.tables.records.PdmTableRecord;
import com.pdmweb.common.utils.DateUtil;
import com.pdmweb.common.utils.PdmUtil;
import com.pdmweb.common.utils.UUIDUtils;
import com.pdmweb.pdm.service.PdmwebService;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdmwebServiceImpl extends BaseTables implements PdmwebService {

    @Autowired
    private DSLContext dsl;

    @Transactional
    public void analysePdm(MultipartFile file) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(file.getInputStream());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PdmListRecord pdmRecord = new PdmListRecord();
        pdmRecord.setPdmName(file.getOriginalFilename());
        pdmRecord.setUpdateTime(DateUtil.getNowTime());
        pdmRecord.setCreateTime(DateUtil.getNowTime());
        pdmRecord.setPdmVersion("1.0");
        pdmRecord.setPdmStatus(1);
        String pdmId = dsl.insertInto(listTable).set(pdmRecord).returning(listTable.PDM_ID).fetchOne().get("pdm_id").toString();


        Element rootElement = document.getRootElement();

        Namespace oNamespace = new Namespace("o", "object");
        Namespace cNamespace = new Namespace("c", "collection");
        Namespace aNamespace = new Namespace("a", "attribute");

        Element rootObject = rootElement.element(new QName("RootObject", oNamespace));

        Element children = rootObject.element(new QName("Children", cNamespace));
        Element model = children.element(new QName("Model", oNamespace));

        List<Element> tableEles = new ArrayList<>();

        // 解析package
        Element packagesEle = model.element(new QName("Packages", cNamespace));
        if (packagesEle != null) {
            List<Element> packageEles = packagesEle.elements(new QName("Package", oNamespace));
            for (Element packageEle : packageEles) {
                Element tablesEle = packageEle.element(new QName("Tables", cNamespace));
                if (tablesEle != null) {
                    tableEles.addAll(tablesEle.elements(new QName("Table", oNamespace)));
                }
            }
        }

        // 直接解析table
        Element tablesEle = model.element(new QName("Tables", cNamespace));
        if (tablesEle != null) {
            tableEles.addAll(tablesEle.elements(new QName("Table", oNamespace)));
        }

        PdmTableRecord tableBean;
        List<PdmTableRecord> tableList = new ArrayList<>();
        PdmTableFieldRecord tableFieldBean;
        List<PdmTableFieldRecord> tableFieldList = new ArrayList<>();

        int i = 0;
        for (Element tableElement : tableEles) {
            i++;
            Element name = tableElement.element(new QName("Name", aNamespace));
            Element code = tableElement.element(new QName("Code", aNamespace));
            Long tableId = UUIDUtils.getLongId();

            tableBean = new PdmTableRecord();
            tableBean.setTableId(tableId);
            tableBean.setPdmId(pdmId);
            tableBean.setTableCode(code.getText());
            tableBean.setTableDesc(name.getText());
            tableBean.setCreateTime(DateUtil.getNowTime());
            tableList.add(tableBean);

            // 解析主键
            Element primaryKeyEle = tableElement.element(new QName("PrimaryKey", cNamespace));
            List<String> pkIds = new ArrayList<>();
            if (primaryKeyEle != null) {
                List<Element> pks = primaryKeyEle.elements(new QName("Key", oNamespace));
                for (Element pk1 : pks) {
                    pkIds.add(pk1.attribute("Ref").getValue());
                }
            }

            Element keysEle = tableElement.element(new QName("Keys", cNamespace));
            List<String> pkColumnIds = new ArrayList<>();
            if (keysEle != null) {
                List<Element> keyEleList = keysEle.elements(new QName("Key", oNamespace));
                for (Element keyEle : keyEleList) {
                    Attribute id = keyEle.attribute("Id");
                    if (pkIds.contains(id.getValue())) {
                        List<Element> list = keyEle.element(new QName("Key.Columns", cNamespace)).elements(new QName("Column", oNamespace));
                        for (Element element : list) {
                            pkColumnIds.add(element.attribute("Ref").getValue());
                        }
                    }
                }
            }


            // 解析column
            List<Element> columns = tableElement.element(new QName("Columns", cNamespace)).elements(new QName("Column", oNamespace));
            for (Element columnEle : columns) {
                String columnId = columnEle.attribute("Id").getValue();
                Element fileCode = columnEle.element(new QName("Code", aNamespace));
                Element fieldType = columnEle.element(new QName("DataType", aNamespace));
                Element fieldSize = columnEle.element(new QName("Length", aNamespace));
                Element cComment = columnEle.element(new QName("Comment", aNamespace));
                Element nullable = columnEle.element(new QName("Column.Mandatory", aNamespace));

                tableFieldBean = new PdmTableFieldRecord();
                tableFieldBean.setFieldId(UUIDUtils.getLongId());
                tableFieldBean.setTableId(tableId);
                tableFieldBean.setFieldCode(fileCode.getText());
                if (fieldType != null) {
                    tableFieldBean.setFieldType(fieldType.getText());
                }

                if (fieldSize != null) {
                    tableFieldBean.setFieldSize(Integer.valueOf(fieldSize.getText()));
                }

                if (pkColumnIds.contains(columnId)) {
                    tableFieldBean.setFieldPrimary("√");
                }

                if (nullable != null) {
                    tableFieldBean.setFieldIsnull("M");
                }

                if (cComment != null) {
                    tableFieldBean.setFieldDesc(PdmUtil.getTextFromEle(cComment));
                }
                tableFieldList.add(tableFieldBean);
            }

        }

        dsl.batchInsert(tableList).execute();
        dsl.batchInsert(tableFieldList).execute();

//        System.out.println("表标题分别为 列代码/类型/长度/是否为主键/是否允许为空/列可读名称及备注");
//        System.out.println("      √ 表示主键， M 表示不能为空");
    }




}
