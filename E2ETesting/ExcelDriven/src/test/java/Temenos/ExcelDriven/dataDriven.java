package Temenos.ExcelDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		FileInputStream file = new FileInputStream("C:\\UserDrive\\Prashan\\ExcelDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		ArrayList<String> a = new ArrayList<String>();

		int count = workbook.getNumberOfSheets();
		int colIndex = 0;
		// To identity the Sheets
		for (int i = 0; i < count; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);// sheet is collection of rows

				// 1.identify required column ("Testcases") by scanning the entire 1st row
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next(); // control comes to first row
				Iterator<Cell> cell = firstrow.cellIterator();// row is collection of cells

				while (cell.hasNext()) {
					Cell column = cell.next();
					if (column.getStringCellValue().equalsIgnoreCase("Testcases")) {
						// we get the desired column
						// 2.once column is identified then scan entire column to retrieve the
						// "purchase" testcase
						colIndex = column.getColumnIndex();
					}
				}
				System.out.println(colIndex);

				while (rows.hasNext()) {
					// we iterate through the rows in the specified column
					Row r = rows.next();
					Cell c = r.getCell(colIndex);
					
					if (c.getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> itc = r.cellIterator();
						while (itc.hasNext()) {
							//System.out.println(itc.next().getStringCellValue());
							//Code for handling numerice datas also 
								Cell cc =	itc.next();
								if(cc.getCellType()==CellType.STRING)
								{
									a.add(cc.getStringCellValue());
								}
								else
								{
									//conversion of number to string
									a.add(NumberToTextConverter.toText(cc.getNumericCellValue()));
								}
							
						}
					}
				}

			}
		}
		return a;

		/** Strategy to get all the datas of Purchase testcase **/
		// 1.identify Testcases column by scanning the entire 1st row

		// 3.once the specific row is identified , pull all the data of that row and
		// feed to the test case

	}

}
