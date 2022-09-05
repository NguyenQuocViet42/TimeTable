/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Subject {

    public String id;       // Mã học phần
    public String name;  // Tên học phần
    public ArrayList<Class> listClass = new ArrayList<Class>(); // Danh sách các lớp của học phần này
    public String flagLT, flagBT, flagTN;   // Đánh dấu học phần này có những loại lớp nào

    public Subject(String id, String name, String flagLT, String flagBT, String flagTN) {
        this.id = id;
        this.name = name;
        this.flagBT = flagBT;
        this.flagLT = flagLT;
        this.flagTN = flagTN;
    }

    public String getId() {
        return this.id;
    }
    // Thêm lớp vào danh sách lớp
    public void addClass(Class newClass) {
        listClass.add(newClass);
    }
}
