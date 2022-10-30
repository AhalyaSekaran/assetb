package com.verinite.assetmangementtool.service;

//import com.lowagie.text.Font;
//import com.lowagie.text.*;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;

import com.verinite.assetmangementtool.entity.AssetsEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.DocumentFormatException;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//public class AddingTableToPDF {
//    private AssetsEntity listUsers;
//    private String invoice;
//    private String currentDateTime;
//
//    public AddingTableToPDF(String invoce, AssetsEntity listUsers1, String currentDateTime) {
//          //this.listUsers = listUsers;
//        this.listUsers = listUsers1;
//        this.invoice = invoce;
//        this.currentDateTime = currentDateTime;
//    }
//
//
//    private void writeTableHeader(PdfPTable table) throws IOException {
//
//        PdfPCell cell = new PdfPCell();
//        // cell.setBackgroundColor(Color.BLUE);
//        cell.setBackgroundColor(Color.BLUE);
//        cell.setPadding(7);
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        //font.setColor(Color.WHITE);
//        font.setColor(Color.WHITE);
//
//        cell.setPhrase(new Phrase("assetName", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("serialNumber", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("empId", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("status", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("type", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("purchaseDate", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("warrantyDate", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("location", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("modelName", font));
//        table.addCell(cell);
//
//        cell.setPhrase(new Phrase("operatingSystem", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("returnDate", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("addedBy", font));
//        table.addCell(cell);
//        cell.setPhrase(new Phrase("assignedDate", font));
//        table.addCell(cell);
//    }
//    private void writeTableData(PdfPTable table) {
//        AssetsEntity user = listUsers;
//        table.addCell(user.getAssetName());
//        table.addCell(user.getSerialNumber());
//        table.addCell(user.getEmpId());
//        table.addCell(user.getStatus());
//        table.addCell(user.getType());
//        table.addCell(user.getPurchaseDate());
//        table.addCell(user.getWarrantyDate());
//        table.addCell(user.getLocation());
//        table.addCell(user.getModelName());
//        table.addCell(user.getOperatingSystem());
//       // table.addCell(user.getReturnDate());
//        table.addCell(user.getAddedBy());
//        //table.addCell(user.getAssignedDate()));
//        PdfPCell cell;
//        cell = new PdfPCell();
//        cell.setColspan(6);
//        table.addCell(cell);
//        for (int aw = 0; aw < 6; aw++) {
//        }
//    }
//    public void export(HttpServletResponse response, String s, String currentDateTime) throws DocumentException, IOException {
//        Document document = new Document(PageSize.A4);
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        font.setSize(18);
//        font.setColor(Color.BLUE);
//        Paragraph p1 = new Paragraph(invoice);
//        Paragraph p2 = new Paragraph(currentDateTime);
//        p2.setAlignment(Paragraph.ALIGN_RIGHT);
//        p1.setAlignment(Paragraph.ALIGN_RIGHT);
//        Paragraph p = new Paragraph("Assets Receipt", font);
//        p.setAlignment(Paragraph.ALIGN_CENTER);
//
//        document.add(p1);
//        document.add(p2);
//        document.add(p);
//        PdfPTable table = new PdfPTable(7);
//        table.setWidthPercentage(100f);
//        table.setWidths(new float[]{3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f});
//        table.setSpacingBefore(10);
//        writeTableHeader(table);
//        System.out.println("Header currect");
//        writeTableData(table);
//        System.out.println("Table Data currect");
//
//        document.add(table);
//        document.close();
//
//    }
//}
//

public class UserExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private   AssetsEntity listUsers;
    // private AssetsEntity listUsers;

    private String invoice;
    private String currentDateTime;


    public UserExcelExporter(String invoce, AssetsEntity listUsers1, String currentDateTime) {
        this.listUsers = listUsers1;
        workbook = new XSSFWorkbook();
//        this.listUsers = listUsers1;
        this.invoice = invoce;
        this.currentDateTime = currentDateTime;
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Asset Id", style);
        createCell(row, 1, "Asset Name", style);
        createCell(row, 2, "Serial No", style);
        createCell(row, 3, "Emp Id", style);
        createCell(row, 4, "Status", style);
        createCell(row, 5, "Type", style);
        createCell(row, 6, "Purchase Date", style);
        createCell(row, 7, "Warrenty Date", style);
        createCell(row, 8, "Location", style);
        createCell(row, 9, "Model Name", style);
        createCell(row, 10, "Opreating System", style);
        createCell(row, 11, "Return Date", style);
        createCell(row, 12, "Added By", style);
        createCell(row, 13, "Assinged Data", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

//        for (AssetsEntity user : listUsers) {
        Row row = sheet.createRow(rowCount++);
        int columnCount = 0;

        createCell(row, columnCount++, listUsers.getAssetId(), style);
        createCell(row, columnCount++, listUsers.getAssetName(), style);
        createCell(row, columnCount++, listUsers.getSerialNumber(), style);
        createCell(row, columnCount++, listUsers.getEmpId(), style);
        createCell(row, columnCount++, listUsers.getStatus(), style);
        createCell(row, columnCount++, listUsers.getType(), style);
        createCell(row, columnCount++, listUsers.getPurchaseDate(), style);
        createCell(row, columnCount++, listUsers.getWarrantyDate(), style);
        createCell(row, columnCount++, listUsers.getLocation(), style);
        createCell(row, columnCount++, listUsers.getModelName(), style);
        createCell(row, columnCount++, listUsers.getOperatingSystem(), style);
        createCell(row, columnCount++, listUsers.getReturnDate(), style);
        createCell(row, columnCount++, listUsers.getAddedBy(), style);
        createCell(row, columnCount++, listUsers.getAssignedBy(), style);
        //createCell(row, columnCount++, user.isEnabled(), style);

    }
//    }

    //    public void export(HttpServletResponse response, String s, String currentDateTime) throws DocumentException, IOException {

    public void export(HttpServletResponse response,String s,String currentDateTime) throws DocumentFormatException,IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}