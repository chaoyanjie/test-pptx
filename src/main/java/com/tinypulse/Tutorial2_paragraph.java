package com.tinypulse;

import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by antran on 3/29/16.
 */
public class Tutorial2_paragraph {
    public static void main(String[] args) throws IOException {
        XMLSlideShow ppt = new XMLSlideShow();

        XSLFSlide slide1 = ppt.createSlide();
        XSLFTextBox shape1 = slide1.createTextBox();
        // initial height of the text box is 100 pt but
        Rectangle anchor = new Rectangle(10, 100, 300, 100);
        shape1.setAnchor(anchor);

        XSLFTextParagraph p1 = shape1.addNewTextParagraph();
        XSLFTextRun r1 = p1.addNewTextRun();
        r1.setText("Paragraph Formatting");
        r1.setFontSize(24d);
        r1.setFontColor(new Color(85, 142, 213));

        XSLFTextParagraph p2 = shape1.addNewTextParagraph();
        // If spaceBefore >= 0, then space is a percentage of normal line height.
        // If spaceBefore < 0, the absolute value of linespacing is the spacing in points
        p2.setSpaceBefore(-20d); // 20 pt from the previous paragraph
        p2.setSpaceAfter(300d); // 3 lines after the paragraph
        XSLFTextRun r2 = p2.addNewTextRun();
        r2.setText("Paragraph  properties apply to all text residing within the corresponding paragraph.");
        r2.setFontSize(16d);

        XSLFTextParagraph p3 = shape1.addNewTextParagraph();

        XSLFTextRun r3 = p3.addNewTextRun();
        r3.setText("Run Formatting");
        r3.setFontSize(24d);
        r3.setFontColor(new Color(85, 142, 213));

        XSLFTextParagraph p4 = shape1.addNewTextParagraph();
        p4.setSpaceBefore(-20d); // 20 pt from the previous paragraph
        p4.setSpaceAfter(300d); // 3 lines after the paragraph
        XSLFTextRun r4 = p4.addNewTextRun();
        r4.setFontSize(16d);
        r4.setText(
                "Run level formatting is the most granular property level and allows " +
                        "for the specifying of all low level text properties. The text run is " +
                        "what all paragraphs are derived from and thus specifying various " +
                        "properties per run will allow for a diversely formatted text paragraph.");

        // resize the shape to fit text
        shape1.resizeToFitText();

        FileOutputStream out = new FileOutputStream("text.pptx");
        ppt.write(out);
        out.close();

        ppt.close();
    }
}
