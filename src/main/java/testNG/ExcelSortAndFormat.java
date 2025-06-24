package testNG;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

                public class ExcelSortAndFormat {
	
	
	            public static boolean processFile(String filepath) {
	            try {
	            FileInputStream file = new FileInputStream(filepath);
	            Workbook workbook = new XSSFWorkbook(file);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
	            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	            ArrayList<String> data = new ArrayList<>();
	            for (int i = 0; i <= rowCount; i++) {
	            Row row = sheet.getRow(i);
	            Cell cell = row.getCell(0); // Assuming data is in the first column
	            data.add(cell.getStringCellValue());
	            }
	            Collections.sort(data);
	            for (String item : data) {
	            	
	            System.out.println(item);
	            }
	            workbook.close();
	            file.close();
	            return true; // Indicate successful processing
	            } catch (IOException e) {
	            e.printStackTrace();
	            return false; // Indicate failure
	            }
	            }	
	            public static void main(String[] args) throws IOException {
	    	    processFile("C:\\Users\\Demo\\OneDrive - SIMPLIFY3X SOFTWARE PRIVATE LIMITED\\Desktop\\Sort.xlsx");    	   
	            }}
	        		
	    