package Object;

/**
 *
 * @author ASUS
 */
public class Class {

    public String name;         // Tên học phần
    public String id;              // Mã lớp
    public String kindClass;   //  Loại lớp
    public String kClass;       // Mã lớp kèm
    public int time[][] = new int[12][7];   // Ma trận lưu thời gian của lớp
    public String week;         // Tuần học
    public String room;         // Phòng học

    public Class(String id, String name, int[][] time, String kindClass, String kClass, String week) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.kindClass = kindClass;
        this.kClass = kClass;
        this.week = week;
    }
    // Lấy ra loại lớp
    public String getKindClass() {
        return "(" + this.kindClass + ") " + this.name;
    }
}
// tét
// test 250