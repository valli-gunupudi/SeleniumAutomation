package com.tekarch.commonTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FirstProgram {
	
	public static void create() throws IOException {
		String Dirpath=System.getProperty("user.dir");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("UserData");
		FileOutputStream fileOut = new FileOutputStream(new File(Dirpath+"/src/test/resources/new.xlsx"));
        wb.write(fileOut);
        fileOut.close();
        wb.close();
        System.out.println("completed");
		
	}
	public static void readSingleData() throws IOException {
		String Dirpath=System.getProperty("user.dir");
		FileInputStream fi=new FileInputStream(new File(Dirpath+"/resources/jan2024.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		
		XSSFSheet sheet=wb.getSheet("sh1");
		XSSFRow row= sheet.getRow(1);
		XSSFCell cell= row.getCell(0);
		if(cell.getCellType()== CellType.STRING) {
			System.out.println(cell.getStringCellValue());
		}
		else if(cell.getCellType()== CellType.NUMERIC)
			System.out.println(cell.getNumericCellValue());
		wb.close();
		fi.close();
		
		System.out.println("completed");
		
	}
	
	public static void readAlldatafromxlsxfile()throws IOException {
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/jan2024.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet("sh1");
		
		Iterator<Row> rowit=sheet.rowIterator();
		while(rowit.hasNext()) {
			Row row=rowit.next();
			Iterator<Cell> cellit= row.cellIterator();
			while(cellit.hasNext()) {
				Cell cell=cellit.next();
				switch(cell.getCellType()) {
				case STRING:
                    System.out.print(cell.getStringCellValue() + "\t");
                    break;
                case NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t");
                    break;
                case BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t");
                    break;
                case FORMULA:
                    System.out.print(cell.getCellFormula() + "\t");
                    break;
                case BLANK:
                    System.out.print("BLANK\t");
                    break;
                default:
                    System.out.print("UNKNOWN\t");
				}
			
			}
			System.out.println();
		}
		
		fi.close();
		
		

	}
	
	public static void main(String[] args) throws IOException {
		//readAlldatafromxlsxfile();
		create();
	}
}
