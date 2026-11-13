package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
	public String toreaddatafromexcel(String Sheetname,int Rownum,int Cellnum) throws Throwable, Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(Sheetname).getRow(Rownum).getCell(Cellnum).getStringCellValue();
		return data;
	}
	

}
