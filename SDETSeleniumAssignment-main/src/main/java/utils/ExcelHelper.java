package utils;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
    private static XSSFWorkbook ExcelWBook;
    private static XSSFSheet ExcelWSheet;
    private static XSSFRow xrow;
    private static XSSFCell xcell;
    static int rowNum,cellNum;
    static Logger logger = Logger.getLogger(ExcelHelper.class.getName());	
	
    public ExcelHelper() {
    	PropertyConfigurator.configure(Constants.LOG4J_PROPERTY_FILE);
    }
	
public static String[][] getExcelFile(String path,String sheetName) throws Exception {
	
		
		FileInputStream ExcelFile;
		String data[][] = null;
		int type = 0;
		String sheetname=sheetName;
		
		
		logger.info("file path is "+path);
		ExcelFile = new FileInputStream(path);
		logger.info("trying to Openinig Of Excel");
		ExcelWBook  =new XSSFWorkbook(ExcelFile);		

		FormulaEvaluator evaluator = ExcelWBook.getCreationHelper().createFormulaEvaluator();
		 ExcelWSheet=ExcelWBook.getSheet(sheetname);
		 logger.info("Opened Of Excel sheet was "+sheetname);
		rowNum = ExcelWSheet.getLastRowNum()+1;
		data = new String[rowNum][];

		for (int i = 0; i < rowNum ; i++) {
			xrow=ExcelWSheet.getRow(i);
			cellNum = xrow.getLastCellNum();
			data[i]=new String[cellNum];
			for (int j = 0; j < cellNum; j++) {
				xcell = ExcelWSheet.getRow(i).getCell(j);
				try{
				type=evaluator.evaluateInCell(xcell).getCellType();
				}catch(Exception e){e.printStackTrace();}
				if((type)==1){
				switch (type) {
				case XSSFCell.CELL_TYPE_BLANK:		
					data[i][j]=String.valueOf(" ").trim();
					break;
				case XSSFCell.CELL_TYPE_ERROR:
					data[i][j]=String.valueOf(xcell.getErrorCellValue()).trim();
					break;
				case XSSFCell.CELL_TYPE_FORMULA:
					data[i][j]=String.valueOf(xcell.getCellFormula()).trim();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
	        		data[i][j]=String.valueOf(xcell.getNumericCellValue()).trim();
	
					break;
				case XSSFCell.CELL_TYPE_STRING:
			    	data[i][j]=xcell.getStringCellValue().trim();
					break;
				default:
					
					 logger.info("Cell not found");
				}
			  }
			}			
		}
		return data;
	}
	
	
	}

