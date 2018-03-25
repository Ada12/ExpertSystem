package service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 2018/1/18.
 */
public class SaveResultToXlsx implements Runnable {

    private Map<String, Object> params;
    private String path;

    public void setParams(Map<String, Object> params){
        this.params = params;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void run(){
        XSSFWorkbook wb;
        XSSFSheet result;
        File excel = new File(path + "param.xlsx");
        try {
            FileOutputStream out = new FileOutputStream(excel);
            if (excel.exists()) {
                wb = (XSSFWorkbook) WorkbookFactory.create(excel);
                result = wb.createSheet("Result");
            } else {
                wb = new XSSFWorkbook();
                result = wb.createSheet("Result");
            }
            XSSFCellStyle style = wb.createCellStyle();
            // result
            XSSFRow resultRow;
            resultRow = result.createRow(0);
            result.addMergedRegion(new CellRangeAddress(0,0,0,6));
            resultRow.createCell(0).setCellValue("Vehicle Performance");
            resultRow = result.createRow(1);
            resultRow.createCell(0).setCellValue("");
            resultRow.createCell(1).setCellValue("Metric");
            resultRow.createCell(2).setCellValue("Value");
            resultRow.createCell(3).setCellValue("Min");
            resultRow.createCell(4).setCellValue("Req");
            resultRow.createCell(5).setCellValue("Max");
            resultRow.createCell(6).setCellValue("Unix");
            String[] resultParam1 = new String[]{"Preload：Pedal Force", "Onset Pedal force @0.05g", "Onset Pedal Travel @0.05g",
                    "Normal Pedal force（Onset+0.5）", "Normal Pedal travel（Onset+0.5）", "Pedal Force @0.8g GVW", "Pedal Force @0.9g GVW",
                    "Pedal Force @1g GVW", "Linearity Pedal Force", "Linearity Pedal Travel", "Tire k @ 0.7g GVW", "Tire k @ 0.8g GVW",
                    "Tire k @ 0.9g GVW", "Max GVW Decel", "Max LVW Decel"};
            String[] resultUnit1 = new String[]{"N", "N", "mm", "N", "mm", "N", "N", "N", "N/A", "N/A", "N/A", "N/A", "N/A", "g", "g"};
            List<String> bfi = (List<String>) params.get("BFI");
            resultRow = result.createRow(2);
            result.addMergedRegion(new CellRangeAddress(2,16,0,0));
            resultRow.createCell(0).setCellValue("BFI");
            for (int i = 2; i < 17; i ++) {
                if (i != 2) {
                    resultRow = result.createRow(i);
                }
                resultRow.createCell(1).setCellValue(resultParam1[i-2]);
                resultRow.createCell(2).setCellValue(bfi.get((i-2)*4));
                resultRow.createCell(3).setCellValue(bfi.get((i-2)*4 + 1));
                resultRow.createCell(4).setCellValue(bfi.get((i-2)*4 + 2));
                resultRow.createCell(5).setCellValue(bfi.get((i-2)*4 + 3));
                resultRow.createCell(6).setCellValue(resultUnit1[i-2]);
            }
            String[] resultParam2 = new String[]{"LVW Z Critical", "GVW Z Critical"};
            String[] resultUnit2 = new String[]{"N/A", "N/A"};
            List<String> brkBalance = (List<String>) params.get("Brake Balance");
            resultRow = result.createRow(17);
            result.addMergedRegion(new CellRangeAddress(17,18,0,0));
            resultRow.createCell(0).setCellValue("Brake Balance");
            for (int i = 17; i < 19; i ++) {
                if (i != 17) {
                    resultRow = result.createRow(i);
                }
                resultRow.createCell(1).setCellValue(resultParam2[i-17]);
                resultRow.createCell(2).setCellValue(brkBalance.get((i-17)*4));
                resultRow.createCell(3).setCellValue(brkBalance.get((i-17)*4 + 1));
                resultRow.createCell(4).setCellValue(brkBalance.get((i-17)*4 + 2));
                resultRow.createCell(5).setCellValue(brkBalance.get((i-17)*4 + 3));
                resultRow.createCell(6).setCellValue(resultUnit2[i-17]);
            }

            String[] resultParam3 = new String[]{"Decel Booster Runout GVW", "Decel Booster Runout LVW"};
            String[] resultUnit3 = new String[]{"g", "g"};
            List<String> bstRun = (List<String>) params.get("Booster Runout");
            resultRow = result.createRow(19);
            result.addMergedRegion(new CellRangeAddress(19,20,0,0));
            resultRow.createCell(0).setCellValue("Booster Runout");
            for (int i = 19; i < 21; i ++) {
                if (i != 19) {
                    resultRow = result.createRow(i);
                }
                resultRow.createCell(1).setCellValue(resultParam3[i-19]);
                resultRow.createCell(2).setCellValue(bstRun.get((i-19)*4));
                resultRow.createCell(3).setCellValue(bstRun.get((i-19)*4 + 1));
                resultRow.createCell(4).setCellValue(bstRun.get((i-19)*4 + 2));
                resultRow.createCell(5).setCellValue(bstRun.get((i-19)*4 + 3));
                resultRow.createCell(6).setCellValue(resultUnit3[i-19]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

}
