/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package writereadexcel;

import Method.Methods;
import Object.Class;
import Object.Subject;
import View.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Math;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ASUS
 */
public class ReadExcel {

    View view;
    Methods method = new Methods();

    /**
     * @param args the command line arguments
     */
    public ReadExcel() {
    }

    public ReadExcel(View view) {
        this.view = view;
    }

    // Load danh sách môn
    public void readExcelSubject() throws FileNotFoundException, IOException {

        String name, id, flagLT, flagBT, flagTN;
        FileInputStream file = new FileInputStream("Subject.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        int r = 0;
        try {
            for (r = 0; r < 8; r++) {
                id = sheet.getRow(r).getCell(0).getStringCellValue();
                name = sheet.getRow(r).getCell(1).getStringCellValue();
                flagLT = sheet.getRow(r).getCell(2).getStringCellValue();
                flagBT = sheet.getRow(r).getCell(3).getStringCellValue();
                flagTN = sheet.getRow(r).getCell(4).getStringCellValue();
                view.listSubject.add(new Subject(id, name, flagLT, flagBT, flagTN));
            }
        } catch (Exception e) {
            System.out.println("Subject");
            System.out.println(r);
        }

        wb.close();
        file.close();
    }

    // Load danh sách lóp
    public void readExcelClass() throws FileNotFoundException, IOException {
        String name, id, start, end, day, kind, kClass, week;
        FileInputStream file = new FileInputStream("class.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
        int r = 0;
        try {
            for (r = 0; r < 58; r++) {

                name = sheet.getRow(r).getCell(1).getStringCellValue();
                // Get ID
                if (sheet.getRow(r).getCell(0).getCellType() == CellType.NUMERIC) {
                    id = (int) Math.round(sheet.getRow(r).getCell(0).getNumericCellValue()) + "";
                } else {
                    id = sheet.getRow(r).getCell(0).getStringCellValue();
                }
                // Get time start
                if (sheet.getRow(r).getCell(2).getCellType() == CellType.NUMERIC) {
                    start = (int) Math.round(sheet.getRow(r).getCell(2).getNumericCellValue()) + "";
                } else {
                    start = sheet.getRow(r).getCell(2).getStringCellValue();
                }
                //get time end
                if (sheet.getRow(r).getCell(3).getCellType() == CellType.NUMERIC) {
                    end = (int) Math.round(sheet.getRow(r).getCell(3).getNumericCellValue()) + "";
                } else {
                    end = sheet.getRow(r).getCell(3).getStringCellValue();
                }
                //get day
                if (sheet.getRow(r).getCell(4).getCellType() == CellType.NUMERIC) {
                    day = (int) Math.round(sheet.getRow(r).getCell(4).getNumericCellValue()) + "";
                } else {
                    day = sheet.getRow(r).getCell(4).getStringCellValue();
                }
                //getkind
                kind = sheet.getRow(r).getCell(5).getStringCellValue() + "";
                //get kClass
                if (sheet.getRow(r).getCell(6).getCellType() == CellType.NUMERIC) {
                    kClass = (int) Math.round(sheet.getRow(r).getCell(6).getNumericCellValue()) + "";
                } else {
                    kClass = sheet.getRow(r).getCell(6).getStringCellValue();
                }
                week = sheet.getRow(r).getCell(7).getStringCellValue();
                int time[][] = Methods.getTime(Integer.parseInt(day), Integer.parseInt(start), Integer.parseInt(end));
                Class newClass = new Class(id, name, time, kind, kClass, week);
                for (Subject subject : view.listSubject) {
                    if (subject.name.equals(newClass.name)) {
                        if (kind.equals("LT")) {
                            for (Class tmp : subject.listClass) {
                                if (tmp.kClass.equals(id)) {
                                    view.listClass.add(newClass);
                                    tmp.time = Methods.addMatrix(tmp.time, time);
                                    tmp.kindClass = "LT+BT";
                                }
                            }
                        } else {
                            view.listClass.add(newClass);
                            subject.addClass(newClass);
                        }
                        break;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Class");
            System.out.println(r);
        }
        wb.close();
        file.close();
    }

    // Lưu dữ liệu người dùng
    public static void saveData() throws FileNotFoundException, IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        for (int r = 0; r < 12; r++) {
            Row row = sheet.createRow(r);
            for (int c = 0; c < 7; c++) {
                if (c != 0) {
                    String id = View.viewSubject[r][c];
                    row.createCell(c + 9).setCellValue(id);
                }
                row.createCell(c).setCellValue(View.viewTime[r][c]);
            }

        }
        int i = 14;
        for (String name : View.listSubjectAdded) {
            Row row = sheet.createRow(i++);
            row.createCell(0).setCellValue(name);
        }

        // Write the output to a file  
        FileOutputStream fileOut = new FileOutputStream("data.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        Workbook wb = new XSSFWorkbook();
        Sheet st = wb.createSheet("Sheet1");
        i = 0;
        for (Subject subject : View.listSubject) {
            Row row = st.createRow(i);
            row.createCell(0).setCellValue(subject.id);
            row.createCell(1).setCellValue(subject.name);
            row.createCell(2).setCellValue(subject.flagLT);
            row.createCell(3).setCellValue(subject.flagBT);
            row.createCell(4).setCellValue(subject.flagTN);
            i++;
        }
        FileOutputStream fo = new FileOutputStream("Subject.xlsx");
        wb.write(fo);
        fo.close();
// Closing the workbook  
        workbook.close();
    }

    // Load dữ liệu người dùng
    public void loadData() throws FileNotFoundException, IOException {

        FileInputStream file = new FileInputStream("data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        int x;
        int r = 0, c = 0;
        try {
            for (r = 0; r < 12; r++) {
                for (c = 1; c < 7; c++) {
                    if (sheet.getRow(r).getCell(c).getCellType() == CellType.NUMERIC) {
                        x = (int) Math.round(sheet.getRow(r).getCell(c).getNumericCellValue());
                    } else {
                        x = Integer.parseInt(sheet.getRow(r).getCell(c).getStringCellValue());
                    }
                    view.viewTime[r][c] = x;
                    if (sheet.getRow(r).getCell(c + 9).getCellType() == CellType.NUMERIC) {
                        String id = (int) Math.round(sheet.getRow(r).getCell(c + 9).getNumericCellValue()) + "";
                        if (!"null".equals(id)) {
                            Class classs = method.findClass(id);
                            view.mainTable.setValueAt(classs.name, r, c);
                        }

                        view.viewSubject[r][c] = id;
                    } else {
                        String id = sheet.getRow(r).getCell(c + 9).getStringCellValue() ;
                        if (!"null".equals(id)) {
                            Class classs = method.findClass(id);
                            view.mainTable.setValueAt(classs.name, r, c);
                        }
                        view.viewSubject[r][c] = id;
                    }
                }
            }
            for (r = 14; sheet.getRow(r) != null; r++) {
                String name = sheet.getRow(r).getCell(0).getStringCellValue();
                view.listSubjectAdded.add(name);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(r);
            System.out.println(c);
        }
        wb.close();
        file.close();
    }
}
