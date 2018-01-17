package service;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangchen on 2018/1/10.
 */
public class CopySheet {

//    public static void main(String[] agrs) {
//        try {
//            main("/Users/yangchen/Desktop/result.xlsx", "/Users/yangchen/Desktop/testpic.xlsx", "figure11");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String originName, String newName, String sheetName) throws FileNotFoundException,
            IOException {

        // String strPath = "/Users/yangchen/Desktop/result.xlsx";//excel存放路径
        // String newName = "/Users/yangchen/Desktop/testPic.xlsx";
        File file = new File(originName);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet shBET = wb.getSheet(sheetName);
        createNewExcel(shBET, newName, sheetName);

    }


    private static void createNewExcel(XSSFSheet sheet, String excelName, String newSheetName) throws IOException {
        XSSFWorkbook wbCreat = new XSSFWorkbook();
        XSSFSheet sheetCreat = wbCreat.createSheet(newSheetName);
//        int firstRow = sheet.getRow(0).getPhysicalNumberOfCells();
        int firstRow = 0;
        int lastRow = sheet.getLastRowNum();
        for (int i = firstRow; i <= lastRow; i++) {
            XSSFRow rowCreat = sheetCreat.createRow(i);
            XSSFRow row = sheet.getRow(i);
            XSSFCellStyle cellStyle = null;
            int firstCell = row.getFirstCellNum();
            int lastCell = row.getLastCellNum();
            for (int j = firstCell; j < lastCell; j++) {
                sheetCreat.autoSizeColumn(j);
                try {
                    cellStyle = wbCreat.createCellStyle();
                    cellStyle.setBorderTop(row.getCell(j).getCellStyle().getBorderTop());
                    cellStyle.setBorderBottom(row.getCell(j).getCellStyle().getBorderBottom());
                    cellStyle.setBorderLeft(row.getCell(j).getCellStyle().getBorderLeft());
                    cellStyle.setBorderRight(row.getCell(j).getCellStyle().getBorderRight());
                    cellStyle.setAlignment(row.getCell(j).getCellStyle().getAlignment());
                    cellStyle.setVerticalAlignment(row.getCell(j).getCellStyle().getVerticalAlignment());
                    cellStyle.setWrapText(row.getCell(j).getCellStyle().getWrapText());
                    rowCreat.createCell(j).setCellStyle(cellStyle);
                    rowCreat.getCell(j).getRow().setHeight(row.getCell(j).getRow().getHeight());
                    switch (row.getCell(j).getCellType()) {
                        case XSSFCell.CELL_TYPE_STRING:
                            String strVal = removeInternalBlank(row.getCell(j).getStringCellValue());
                            rowCreat.getCell(j).setCellValue(strVal);
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            rowCreat.getCell(j).setCellValue(row.getCell(j).getNumericCellValue());
                            break;
                        case XSSFCell.CELL_TYPE_FORMULA:
                            try {
                                rowCreat.getCell(j).setCellValue(String.valueOf(row.getCell(j).getNumericCellValue()));
                            } catch (IllegalStateException e) {
                                try {
                                    rowCreat.getCell(j).setCellValue(String.valueOf(row.getCell(j).getRichStringCellValue()));
                                } catch (Exception ex) {
                                    rowCreat.getCell(j).setCellValue("公式出错");
                                }
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        FileOutputStream fileOut = new FileOutputStream(excelName);
        wbCreat.write(fileOut);
        fileOut.close();

    }

    private static String checkFileName(String strPath ,String checkFilename){
        File file = new File (strPath);
        for(File f : file.listFiles()){
            if(f.getName().equals(checkFilename)){
                checkFilename+=checkFilename+"_重名";
                checkFileName(strPath,checkFilename);
                break;
            }
        }
        return checkFilename;
    }

    private static boolean isInMergerCellRegion(HSSFSheet sheet,
                                                int intCellRow, int intCellCol) throws IOException {
        boolean retVal = false;

        int sheetMergerCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergerCount; i++) {
            CellRangeAddress cra = (CellRangeAddress) sheet.getMergedRegion(i);
//            int firstRow = cra.getFirstRow();
            int firstRow = 0;
            int firstCol = cra.getFirstColumn();
            int lastRow = cra.getFirstColumn();
            int lastCol = cra.getLastColumn();

            if (intCellRow >= firstRow && intCellRow <= lastRow) {
                if (intCellCol >= firstCol && intCellCol <= lastCol) {
                    retVal = true;
                    break;
                }
            }
        }
        return retVal;
    }

    public static String removeInternalBlank(String s) {
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(s);
        char str[] = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                sb.append(' ');
            } else {
                break;
            }
        }
        String after = m.replaceAll("");
        return sb.toString() + after;
    }

}
