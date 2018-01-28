package com.yucitms.util;

import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class SimpleDocument {  
	  
    public static void main(String[] args) throws Exception {  
        XWPFDocument doc = new XWPFDocument();  
        XWPFParagraph p3 = doc.createParagraph();  
        p3.setWordWrap(true);  
        p3.setPageBreak(true);  //分页符
                  
        //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);  
        p3.setAlignment(ParagraphAlignment.LEFT);  
       // p3.setSpacingLineRule(LineSpacingRule.EXACT);  
        //p3.setIndentationFirstLine(600);  
          
  
        XWPFRun r4 = p3.createRun();   
        r4.setText("To be, or not to be: that is the question: "  
                + "Whether 'tis nobler in the mind to suffer "  
                + "The slings and arrows of outrageous fortune, "  
                + "Or to take arms against a sea of troubles, "  
                + "And by opposing end them? To die: to sleep; ");  
        //r4.addBreak(BreakType.PAGE); //分页 
        r4.addCarriageReturn();
        r4.setText("No more; and by a sleep to say we end "  
                + "The heart-ache and the thousand natural shocks "  
                + "That flesh is heir to, 'tis a consummation "  
                + "Devoutly to be wish'd. To die, to sleep; "  
                + "To sleep: perchance to dream: ay, there's the rub; "  
                + ".......");  
        r4.addCarriageReturn();
       // r4.setItalic(true);  
//This would imply that this break shall be treated as a simple line break, and break the line after that word:  
  
        XWPFRun r5 = p3.createRun();  
        //r5.setTextPosition(-10);  
        r5.setText("For in that sleep of death what dreams may come");  
        r5.addCarriageReturn();  
        r5.setText("When we have shuffled off this mortal coil,"  
                + "Must give us pause: there's the respect"  
                + "That makes calamity of so long life;");  
        r5.addBreak();  
        r5.setText("For who would bear the whips and scorns of time,"  
                + "The oppressor's wrong, the proud man's contumely,");  
          
        r5.addBreak(BreakClear.ALL);  
        r5.setText("The pangs of despised love, the law's delay,"  
                + "The insolence of office and the spurns" + ".......");  
  
        FileOutputStream out = new FileOutputStream("d:simple.docx");  
        doc.write(out);  
        out.close();  
  
    }  
}  
