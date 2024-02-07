package org.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static final String FILE_PATH = "path/to/your/excel/file.xlsx";

    public static Object[][] readTestData(String sheetName) {
        Object[][] testData = null;
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            testData = new Object[rowCount][columnCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    switch (cell.getCellType()) {
                        case STRING:
                            testData[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            testData[i][j] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            testData[i][j] = cell.getBooleanCellValue();
                            break;
                        case BLANK:
                            testData[i][j] = "";
                            break;
                        default:
                            testData[i][j] = cell.getStringCellValue();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }

    public static void main(String[] args) {
        Object[][] testData = ExcelUtils.readTestData("Sheet1");
        for (Object[] row : testData) {
            for (Object cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}

