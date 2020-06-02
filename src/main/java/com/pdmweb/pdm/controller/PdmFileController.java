package com.pdmweb.pdm.controller;

import com.pdmweb.common.entity.FebsResponse;
import com.pdmweb.common.exception.FebsException;
import com.pdmweb.pdm.service.PdmwebService;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
public class PdmFileController {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private PdmwebService pdmwebService;

    /**
     * 导入pdm数据，并批量插入至表中
     */
    @PostMapping("import")
    public FebsResponse importExcels(MultipartFile file) throws IOException, DocumentException {
        if (file.isEmpty()) {
            throw new FebsException("导入数据为空");
        }
        String fileName = file.getOriginalFilename();
        if (!StringUtils.endsWith(fileName, ".pdm")) {
            return new FebsResponse().message("只支持.pdm类型文件导入!");
        }

        if (dsl.fetch("select * from pdm_list where pdm_name = ?", fileName).size() > 0) return new FebsResponse().message("该文件名称已存在!");

        pdmwebService.analysePdm(file);

        return new FebsResponse().success().message("上传文件成功!");
    }

//    @GetMapping("excel")
//    public void export(QueryRequest queryRequest, Eximport eximport, HttpServletResponse response) {
//        List<Eximport> eximports = this.eximportService.findEximports(queryRequest, eximport).getRecords();
//        ExcelKit.$Export(Eximport.class, response).downXlsx(eximports, false);
//    }

}
