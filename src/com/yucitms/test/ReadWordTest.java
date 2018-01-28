package com.yucitms.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadWordTest {
	
	public static void main(String[] args) throws Exception {
		File file = new File("d:importQsn.docx");  
        String text = "";  
        try {  
            FileInputStream fis = new FileInputStream(file);  
           /* WordExtractor wordExtractor = new WordExtractor(fis);  
            text = wordExtractor.getText();   */  
              
            XWPFDocument doc = new XWPFDocument(fis);  
            List<XWPFParagraph> paras = doc.getParagraphs();  
            for (XWPFParagraph para : paras) {  
               System.out.println(para.getText());  
            }  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
}
