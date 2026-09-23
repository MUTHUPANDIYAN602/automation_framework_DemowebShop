package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import constants.FrameworkConstants;

public class ExcelUtility {

    private static final String EXCEL_PATH ="./src/test/resources/testdata.xlsx";

    // Open Workbook
     
    private static Workbook getWorkbook()throws EncryptedDocumentException, IOException {

        FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_PATH);
        return WorkbookFactory.create(fis);
    }

    // Read Single Cell Data
   
    public static String getSingleDataFromExcel(String sheetName, int rowNum,int cellNum) {

        try (Workbook book = getWorkbook()) {

            Sheet sheet = book.getSheet(sheetName);

            Row row = sheet.getRow(rowNum);

            Cell cell = row.getCell(cellNum);

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

     // Read Multiple Data (DataProvider)
     
    public static String[][] getMultipleDataFromExcel(String sheetName) {

        try (Workbook book = getWorkbook()) {

            Sheet sheet = book.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();

            int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

            String[][] data = new String[rowCount - 1][cellCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < cellCount; j++) {

                    data[i - 1][j] =  formatter.formatCellValue( sheet.getRow(i).getCell(j));
                }
            }

            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    //  Get Row Count
    public static int getRowCount(String sheetName) {

        try (Workbook book = getWorkbook()) {

            return book.getSheet(sheetName).getPhysicalNumberOfRows();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

 // Get Cell Count
    public static int getCellCount(String sheetName) {

        try (Workbook book = getWorkbook()) {

            return book.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

	public static String getExcelPath() {
		return EXCEL_PATH;
	}
}