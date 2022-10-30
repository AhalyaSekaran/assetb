package com.verinite.assetmangementtool.service;

import com.verinite.assetmangementtool.entity.AssetsEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Asset Id", "Asset Name", "Serial No", "Emp Id" , "Status", "Type", "Purchase Date",
            "Warrenty Date", "Location", "Model Name", "Operating System", "Return Date", "Added By", "Assigned Date"};
    static String SHEET = "Tutorials";

    public static ByteArrayInputStream tutorialsToExcel(List <AssetsEntity>tutorials) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (AssetsEntity tutorial : tutorials) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(tutorial.getAssetId());
                row.createCell(1).setCellValue(tutorial.getAssetName());
                row.createCell(2).setCellValue(tutorial.getSerialNumber());
                row.createCell(3).setCellValue(tutorial.getEmpId());
                row.createCell(4).setCellValue(tutorial.getStatus());
                row.createCell(5).setCellValue(tutorial.getType());
                row.createCell(6).setCellValue(tutorial.getPurchaseDate());
                row.createCell(7).setCellValue(tutorial.getWarrantyDate());
                row.createCell(8).setCellValue(tutorial.getLocation());
                row.createCell(9).setCellValue(tutorial.getModelName());
                row.createCell(10).setCellValue(tutorial.getOperatingSystem());
                row.createCell(11).setCellValue(tutorial.getReturnDate());
                row.createCell(12).setCellValue(tutorial.getAddedBy());
                row.createCell(13).setCellValue(tutorial.getAssignedDate());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}