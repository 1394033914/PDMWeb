package com.pdmweb.pdm.controller;

import com.pdmweb.common.utils.PdmUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.fusesource.jansi.Ansi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.Color.*;

/**
 * @author chenjazz
 */
public class MainReader {

	public static void main(String[] args) throws DocumentException {
//        System.out.println();
//        AnsiConsole.systemInstall();
//        if (args.length < 1) {
//            throw new IllegalArgumentException("第一个参数必须是pdm文件路径");
//        }
//    	String fileName = args[0];
		String fileName = "/Users/TymYjmac_Tom/Downloads/物联网数据库修订版.pdm";
		System.out.println(Ansi.ansi().fg(YELLOW).a("File  path:") + Ansi.ansi().fg(Ansi.Color.GREEN).a(fileName).toString());

		long start = System.currentTimeMillis();

		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(fileName));
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

		System.out.println(Ansi.ansi().fg(YELLOW).a("Table size:") + Ansi.ansi().fg(Ansi.Color.GREEN).a(tableEles.size()).toString());

		System.out.println(Ansi.ansi().fgDefault().a(" "));

		int i = 0;
		for (Element tableElement : tableEles) {
			i++;
			Element name = tableElement.element(new QName("Name", aNamespace));
			Element code = tableElement.element(new QName("Code", aNamespace));
			System.out.println("------>" + Ansi.ansi().fg(BLUE).a("NO." + i) + Ansi.ansi().fg(RED).a(" " + name.getText() + " ") + Ansi.ansi().fg(YELLOW).a(" "+code.getText())+" " + Ansi.ansi().fgDefault().a("<-------"));

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
				Element cname = columnEle.element(new QName("Name", aNamespace));
				Element ccode = columnEle.element(new QName("Code", aNamespace));
				Element cDataType = columnEle.element(new QName("DataType", aNamespace));
				Element cLength = columnEle.element(new QName("Length", aNamespace));
				Element cComment = columnEle.element(new QName("Comment", aNamespace));
				Element nullable = columnEle.element(new QName("Column.Mandatory", aNamespace));

				System.out.print(PdmUtil.getPadString(ccode.getText(), 20));
				System.out.print(PdmUtil.getPadString(PdmUtil.getTextFromEle(cDataType), 15));
				System.out.print(PdmUtil.getPadString(PdmUtil.getTextFromEle(cLength), 7));

				if (pkColumnIds.contains(columnId)) {
					System.out.print("√  ");
				} else {
					System.out.print("   ");
				}

				if (nullable != null) {
					System.out.print("M  ");
				} else {
					System.out.print("   ");
				}

				System.out.print(cname.getText());
				if (cComment != null) {
					System.out.print("   (" + PdmUtil.getTextFromEle(cComment).replace("\n", "  ") + ")");
				}
				System.out.println();
			}
			System.out.println();

		}

		System.out.println("================================");
		System.out.println("Use time:" + Ansi.ansi().fg(RED).a((System.currentTimeMillis() - start) / 1000F) + Ansi.ansi().fg(DEFAULT).a("s"));
		System.out.println();
		System.out.print(Ansi.ansi().fg(YELLOW).a("说明： "));
		System.out.print(Ansi.ansi().fg(DEFAULT).a(""));
		System.out.println("表标题分别为 列代码/类型/长度/是否为主键/是否允许为空/列可读名称及备注");
		System.out.println("      √ 表示主键， M 表示不能为空");
		System.out.println();
	}


}
