/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Method;

;
import Object.Class;
import Object.Subject;
import View.View;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import writereadexcel.ReadExcel;
import Object.Class;
import Object.Subject;
import View.View;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import Object.Class;
import Object.Subject;
import View.View;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import writereadexcel.ReadExcel;
import Object.Class;
import Object.Subject;
import View.View;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class Methods implements Action {

    View view;
    ReadExcel readExcel;

    public Methods() {
    }

    ;
    public Methods(View view) {
        this.view = view;
    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cm = e.getActionCommand();
        DefaultTableModel modelClassTable = (DefaultTableModel) view.classTable.getModel();
        DefaultTableModel modelMainTable = (DefaultTableModel) view.mainTable.getModel();
        // T??m m??n h???c
        if (cm.equals("Find")) {
            String id = view.addTextField.getText();        // L???y m?? l???p ng?????i d???ng nh???p
            view.addTextField.setText("");                      // X??a n???i dung ?? nh???p
            id = id.toUpperCase();
            Subject tmp = isHaveSubject(id, view.listSubject);          // Ki???m tra xem m?? h???c ph???n c?? trong d??? li???u kh??ng
            if (tmp == null) {
                if ("".equals(id)) {
                    JOptionPane.showMessageDialog(view, "H??y nh???p m?? h???c ph???n !!");     // N???u kh??ng nh???p g??
                } else {
                    JOptionPane.showMessageDialog(view, "Kh??ng c?? m?? h???c ph???n : " + id);    // N???u nh???p sai m??
                }
            } else if (view.listSubjectAdded.indexOf(tmp.name) != -1 && tmp != null) {      // Ki???m tra trong danh s??ch c??c m??n ???? ???????c th??m
                JOptionPane.showMessageDialog(view, tmp.name + " ???? ???????c th??m");        // N???u ???? ???????c th??m
            } else if (tmp != null && view.listSubjectAdded.indexOf(tmp.name) == -1) {      // N???u c??c ??i???u ki???n th???a m??n
                clearClassTable();                  // L??m m???i classTable
                Subject tmpSubject = findSubject(tmp.name);     // T??m m??n h???c t????ng ???ng
                refreshClassTable(tmpSubject);                          //  Th??m c??c l???p c???a m??n h???c n??y v??o classTable
                view.viewDetailPanel.setVisible(false);
                view.closeButton.setVisible(false);
                view.classTableJScrollPane.setVisible(true);
                view.reloadFrame();
            } // X??a l???p ???? ???????c th??m
        } else if (cm.equals("Delete")) {
            // L???y v??? tr?? ?? ???????c ch???n tr??n mainTable
            int r = view.mainTable.getSelectedRow();
            int c = view.mainTable.getSelectedColumn();
            // N???u c?? ?? ???????c ch???n
            if (r != -1 && c != -1) {
                // N???i dung ?? kh??c r???ng
                if (modelMainTable.getValueAt(r, c) != null) {
                    // L???y m?? l???p m?? ?? ???? ch???a
                    String id = view.viewSubject[r][c];
                    if (!"null".equals(id)) {
                        Class classs = findClass(id);       // T??m l???p ???ng v???i m?? l???p tr??n
                        view.viewTime = subMatrix(view.viewTime, classs.time);   //X??a ????nh d???u tr??n mainTable
                        Subject tmpSubject = findSubject(classs.name);      // T??m m??n ???ng v???i m?? l???p tr??n
                        // reset l???i thu???c t??nh cho m??n n??y
                        if (classs.kindClass.equals("BT")) {
                            tmpSubject.flagBT = "y";
                        }
                        if (classs.kindClass.equals("LT")) {
                            tmpSubject.flagLT = "y";
                        }
                        if (classs.kindClass.equals("TN")) {
                            tmpSubject.flagTN = "y";
                        }
                        if (classs.kindClass.equals("LT+BT")) {
                            tmpSubject.flagBT = "y";
                            tmpSubject.flagLT = "y";
                        }
                        // N???u c?? trong danh s??ch c??c m??n ???? th??m th?? x??a b??? kh???i danh s??ch
                        if (View.listSubjectAdded.contains(classs.name)) {
                            view.listSubjectAdded.remove(classs.name);
                        }
                        //X??a l???p n??y tr??n mainTable
                        for (int j = 0; j < 12; j++) {
                            for (int t = 1; t < 7; t++) {
                                if (classs.time[j][t] != 0) {
                                    modelMainTable.setValueAt("", j, t);
                                    view.viewSubject[j][t] = "null";
                                }
                            }
                        }
                        view.viewDetailPanel.setVisible(false);
                        view.closeButton.setVisible(false);
                        view.classTableJScrollPane.setVisible(true);

                        refreshClassTable(tmpSubject);
                        view.reloadFrame();
                    }

                }

            } // Th??m l???p 
        } else if (cm.equals("Add")) {
            int i = view.classTable.getSelectedRow();
            if (i != -1) {
                // L???y m?? l???p ???????c ch???n v?? t??m l???p t????ng ???ng
                String id = modelClassTable.getValueAt(i, 0) + "";
                Class classs = findClass(id);
                // Ki???m tra xem c?? tr??ng th???i gian kh??ng
                if (isSame(classs.time, view.viewTime) != 1) {
                    // N???u kh??ng tr??ng th?? ti???n h??nh th??m
                    addToMainTable(classs);
                    Subject tmpSubject = findSubject(classs.name);
                    view.viewTime = addMatrix(view.viewTime, classs.time);
                    // Set l???i c??c thu???c t??nh c???a m??n
                    if (classs.kindClass.equals("BT")) {
                        tmpSubject.flagBT = "n";
                    }
                    if (classs.kindClass.equals("LT")) {
                        tmpSubject.flagLT = "n";
                    }
                    if (classs.kindClass.equals("TN")) {
                        tmpSubject.flagTN = "n";
                    }
                    if (classs.kindClass.equals("LT+BT")) {
                        tmpSubject.flagBT = "n";
                        tmpSubject.flagLT = "n";
                    }
                    // N???u c??c thu???c t??nh ?????u l?? "n" (???? add h???t l???p LT, BT, TN) th?? th??m l???p v??o danh s??ch l???p ???? th??m
                    if (tmpSubject.flagLT.equals("n") && tmpSubject.flagTN.equals("n") && tmpSubject.flagBT.equals("n")) {
                        view.listSubjectAdded.add(classs.name);
                    }
                    refreshClassTable(tmpSubject);
                    view.reloadFrame();
                } else {
                    // N???u tr??ng l???ch
                    int concidentTime[] = findCoincidentPosition(view.viewTime, classs.time);
                    Class tmp = findClass(modelMainTable.getValueAt(concidentTime[0], concidentTime[1]) + "");
                    // Ch???n gi???a ghi ???? ho???c gi??? nguy??n
                    int output = JOptionPane.showConfirmDialog(view, "Tr??ng lich m??n " + tmp.name + "\n" + getTimeArr(tmp.time) + "\n" + "Ban co muon thay the khong?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (output == JOptionPane.YES_OPTION) {
                        // N???u ghi ????
                        view.viewTime = subMatrix(view.viewTime, tmp.time);
                        for (int j = 0; j < 12; j++) {
                            for (int t = 1; t < 7; t++) {
                                if (tmp.time[j][t] == 1) {
                                    modelMainTable.setValueAt("", j, t);
                                }
                            }
                        }
                        addToMainTable(classs);
                        view.viewTime = addMatrix(view.viewTime, classs.time);
                        Subject x = findSubject(classs.name);
                        if (classs.kindClass.equals("BT")) {
                            x.flagBT = "n";
                        }
                        if (classs.kindClass.equals("LT")) {
                            x.flagLT = "n";
                        }
                        if (classs.kindClass.equals("TN")) {
                            x.flagTN = "n";
                        }
                        if (classs.kindClass.equals("LT+BT")) {
                            x.flagBT = "n";
                            x.flagLT = "n";
                        }
                        if (x.flagLT.equals("n") && x.flagTN.equals("n") && x.flagBT.equals("n")) {
                            view.listSubjectAdded.add(classs.name);
                        }
                        Subject tmpSubject = findSubject(tmp.name);
                        if (tmp.kindClass.equals("BT")) {
                            tmpSubject.flagBT = "y";
                        }
                        if (tmp.kindClass.equals("LT")) {
                            tmpSubject.flagLT = "y";
                        }
                        if (tmp.kindClass.equals("TN")) {
                            tmpSubject.flagTN = "y";
                        }
                        if (tmp.kindClass.equals("LT+BT")) {
                            tmpSubject.flagBT = "y";
                            tmpSubject.flagLT = "y";
                        }
                        if (View.listSubjectAdded.contains(tmp.name)) {
                            view.listSubjectAdded.remove(tmp.name);
                        }
                        clearClassTable();
                        view.reloadFrame();
                        //N???u kh??ng ghi ????
                    } else if (output == JOptionPane.NO_OPTION) {
                    }
                }
            }
        }
        // Xem th??ng tin l???p
        if (cm.equals("View Detail")) {
            int r = view.mainTable.getSelectedRow();
            int c = view.mainTable.getSelectedColumn();
            Object o = view.mainTable.getValueAt(r, c);
            String id = view.viewSubject[r][c];
            // Ki???m tra xem ?? ???????c ch???n c?? r???ng kh??ng
            if (o != "") {
                // L???y c??c thu???c t??nh c???a l???p v?? hi???n th??? l??n

                view.subjectDetail.setText("");
                view.idDetail.setText("");
                view.kClassDetail.setText("");
                view.weekDetail.setText("");
                view.kindText.setText("");
                view.timeDetail.setText("");
                view.ktimeDetail.setText("");
                Class tmp = findClass(id);
                view.subjectDetail.setText(tmp.name);
                view.idDetail.setText(tmp.id);
                Subject sj = findSubject(tmp.name);
                view.kClassDetail.setText(sj.id);
                view.weekDetail.setText(tmp.week);
                view.kindText.setText(tmp.kindClass);
                if (!"0".equals(tmp.kClass) && !"TN".equals(tmp.kindClass)) {
                    Class ktmp = findClass(tmp.kClass);
                    view.timeDetail.setText(getTimeArr(subMatrix(tmp.time, ktmp.time)));
                    view.ktimeDetail.setText(getTimeArr(ktmp.time));
                } else {
                    view.timeDetail.setText(getTimeArr(tmp.time));
                }
                view.viewDetailPanel.setVisible(true);
                view.closeButton.setVisible(true);
                view.classTableJScrollPane.setVisible(false);
                view.reloadFrame();
            }

        }
        // N???u ch???n ????ng ViewDetail
        if (cm.equals("X")) {
            view.viewDetailPanel.setVisible(false);
            view.closeButton.setVisible(false);
            view.classTableJScrollPane.setVisible(true);
            view.reloadFrame();
        }
        // Luu data
        if (cm.equals("SAVE")) {
            try {
                readExcel.saveData();
            } catch (IOException ex) {
                Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(view, "Saved");
        }
    }

// t??m v?? return vi tr?? tr??ng
    public static int[] findCoincidentPosition(int arr1[][], int arr2[][]) {
        int a[] = new int[2];
        for (int i = 0; i < 12; i++) {            // ti???t
            for (int j = 1; j < 7; j++) {       // th???
                if (arr1[i][j] == 1 && arr2[i][j] == 1) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }
        return a;
    }
// Check xem c?? m??n n??y kh??ng

    public static Subject isHaveSubject(String maHP, ArrayList< Subject> list) {
        for (Subject x : list) {
            if (x.getId().equals(maHP)) {
                return x;
            }
        }
        return null;
    }

    // Them mon vao mainTable
    public void addToMainTable(Class sj) {
        DefaultTableModel modelMainTable = (DefaultTableModel) view.mainTable.getModel();
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 7; j++) {
                if (sj.time[i][j] == 1) {
                    modelMainTable.setValueAt(sj.name, i, j);
                    view.viewSubject[i][j] = sj.id;
                }
            }
        }

    }

    // Xoa o
    public void deleteCell(int r, int c) {
        DefaultTableModel modelMainTable = (DefaultTableModel) view.mainTable.getModel();
        modelMainTable.setValueAt(null, r, c);
        view.viewTime[r][c] = 0;
        view.viewSubject[r][c] = "null";
    }

    //So s??nh 2 ma tran
    public static int isSame(int arr1[][], int arr2[][]) {
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 7; j++) {
                // tr??ng return 1
                if (arr1[i][j] == arr2[i][j] && arr1[i][j] == 1) {
                    return 1;
                }
            }
        }
        // kh??ng return 0;
        return 0;
    }

    // Cong 2 ma tran
    public static int[][] addMatrix(int arr1[][], int arr2[][]) {
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 7; j++) {
                if (arr2[i][j] == 1) {
                    arr1[i][j] = 1;
                }
            }
        }
        return arr1;
    }

    // Tru 2 ma tran
    public int[][] subMatrix(int arr1[][], int arr2[][]) {
        int tmp[][] = new int[12][7];
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 7; j++) {
                tmp[i][j] = arr1[i][j];
            }
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j < 7; j++) {
                tmp[i][j] -= arr2[i][j];
            }
        }
        return tmp;
    }

    // Xoa classTable
    public void clearClassTable() {
        DefaultTableModel modelClassTable = (DefaultTableModel) view.classTable.getModel();
        int n = modelClassTable.getRowCount();
        for (int i = 0; i < n; i++) {
            modelClassTable.removeRow(0);
        }
    }

    // Th??m c??c l???p c???a m??n ???????c ch???n v??o classTable
    public void refreshClassTable(Subject tmp) {
        DefaultTableModel modelClassTable = (DefaultTableModel) view.classTable.getModel();
        clearClassTable();
        if (view.listSubjectAdded.contains(tmp) != true) {
            for (Class newClass : tmp.listClass) {
                if (tmp.flagLT.equals("y") && newClass.kindClass.equals("LT")) {
                    modelClassTable.addRow(new Object[]{newClass.id, getTimeArr(newClass.time), newClass.getKindClass() + ""});
                }
                if (tmp.flagBT.equals("y") && newClass.kindClass.equals("BT")) {
                    modelClassTable.addRow(new Object[]{newClass.id, getTimeArr(newClass.time), newClass.getKindClass() + ""});
                }
                if (tmp.flagTN.equals("y") && newClass.kindClass.equals("TN")) {
                    modelClassTable.addRow(new Object[]{newClass.id, getTimeArr(newClass.time), newClass.getKindClass() + ""});
                }
                if (tmp.flagBT.equals("y") && newClass.kindClass.equals("LT+BT")) {
                    modelClassTable.addRow(new Object[]{newClass.id, getTimeArr(newClass.time), newClass.getKindClass() + ""});
                }
            }
        }
        view.reloadFrame();
    }

    // Chuy???n ma tr???n th???i gian sang d???ng String
    public static String getTimeArr(int arr[][]) {
        String s = new String();
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 12; j++) {
                if (arr[j][i] == 1) {
                    switch (i) {
                        case 1:
                            s = "Mon:";
                            break;
                        case 2:
                            s = "Tue:";
                            break;
                        case 3:
                            s = "Wed:";
                            break;
                        case 4:
                            s = "Thurs:";
                            break;
                        case 5:
                            s = "Fri:";
                            break;
                        case 6:
                            s = "Sat:";
                            break;
                    }
                    switch (j) {
                        case 0:
                            s += " 6h45 -";
                            break;
                        case 1:
                            s += " 7h30 -";
                            break;
                        case 2:
                            s += " 8h25 -";
                            break;
                        case 3:
                            s += " 9h20 -";
                            break;
                        case 4:
                            s += " 10h15 -";
                            break;
                        case 5:
                            s += " 11h00 -";
                            break;
                        case 6:
                            s += " 12h30 -";
                            break;
                        case 7:
                            s += " 13h15 -";
                            break;
                        case 8:
                            s += " 14h10 -";
                            break;
                        case 9:
                            s += " 15h05 -";
                            break;
                        case 10:
                            s += " 16h00 -";
                            break;
                        case 11:
                            s += " 16h45 -";
                            break;
                    }
                    while (j < 12 && arr[j][i] == 1) {
                        j = j + 1;
                    }
                    j = j - 1;
                    switch (j) {
                        case 0:
                            s += " 7h30";
                            break;
                        case 1:
                            s += " 8h15";
                            break;
                        case 2:
                            s += " 9h10";
                            break;
                        case 3:
                            s += " 10h05";
                            break;
                        case 4:
                            s += " 11h00";
                            break;
                        case 5:
                            s += " 11h45";
                            break;
                        case 6:
                            s += " 13h15";
                            break;
                        case 7:
                            s += " 14h00";
                            break;
                        case 8:
                            s += " 14h55";
                            break;
                        case 9:
                            s += " 15h50";
                            break;
                        case 10:
                            s += " 16h45";
                            break;
                        case 11:
                            s += "17h30";
                            break;
                    }
                }
            }
        }
        return s;
    }

    // tim mon theo ten
    public Subject findSubject(String name) {
        for (Subject sj : view.listSubject) {
            if (sj.name.equals(name)) {
                return sj;
            }
        }
        return null;
    }

    // T???o ma tr???n th???i gian t??? c??c th??ng s??? th??m v??o
    public int[][] getTime(int weekday, int start, int end, String K) {
        int arr[][] = new int[12][7];
        int more = 0;
        if (K.equals("C")) {
            more = 6;
        }
        for (int i = start - 1; i < end; i++) {
            arr[i + more][weekday - 1] = 1;
        }
        return arr;
    }

    // T???o ma tr???n th???i gian t??? c??c th??ng s??? th??m v??o
    public static int[][] getTime(int weekday, int start, int end) {
        int arr[][] = new int[12][7];
        for (int i = start - 1; i < end; i++) {
            arr[i][weekday - 1] = 1;
        }
        return arr;
    }

    // tim lop theo mon va id
    public Class findClass(String id) {
        for (Class classs : view.listClass) {
            if (classs.id.equals(id)) {
                return classs;
            }
        }
        return null;
    }
}
