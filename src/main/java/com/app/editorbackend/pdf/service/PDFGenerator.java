package com.app.editorbackend.pdf.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;

public class PDFGenerator {
    private final static int margin = 10;
    private final static int rows = 10;
    private final static int columns = 11;
    private final static int height = 1000;
    private final static int width = 1000;
    private final static int marginLeft = 10;
    private final static int marginRight = 10;
    private final static int marginTop = 10;
    private final static int marginBottom = 10;
    private final static String imageUrl = "";
    private final static String format = "sheet";
    //        private final static String format = "roll";
    private final static String shape = "Rectangle";
    //    private final static String shape = "oval";
//    private final static String shape = "circle";
//    private final static String shape = "continuos";

    public static void main(String args[]) throws Exception {
        Image image = Image.getInstance("C:\\Users\\Vicky\\Desktop\\label.png");
//        generate(image);
    }

    public static void generateFromPreview(Preview preview, String fileName) throws Exception {
        String str = preview.getImage();
        byte[] imagedata = DatatypeConverter.parseBase64Binary(str.substring(str.indexOf(",") + 1));
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
        File logo = new File("./" + fileName + ".png");
        logo.createNewFile();
        ImageIO.write(bufferedImage, "png", logo);
        Image image = Image.getInstance("./" + fileName + ".png");
        PdfPTable table = new PdfPTable(preview.getTemplate().getColumns());
        table.setWidthPercentage(100);
        table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setBorderColor(BaseColor.WHITE);
        table.setKeepTogether(true);
        addRows(table, image, preview.getTemplate().getRows(), preview.getTemplate().getColumns());
        Float h = table.getTotalHeight();
        Rectangle rect = new Rectangle(table.getTotalWidth(), table.getTotalHeight());
//        Document document = new Document(rect);
        Document document = new Document();
//        document.setPageSize(pagesize);
        document.setMargins(2, 2, 2, 2);
        PdfWriter.getInstance(document, new FileOutputStream("./" + fileName + ".pdf"));
        document.open();
//        addImage(document);
        document.add(table);
        document.close();
    }

    private static void addRows(PdfPTable table, Image image, Integer rows, Integer columns) throws IOException, BadElementException {
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                table.addCell(image);
            }
        }
    }
}
