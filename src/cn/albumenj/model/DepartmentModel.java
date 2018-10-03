package cn.albumenj.model;

/**
 * @author Albumen
 */
public class DepartmentModel {
    private int No;
    private int ID;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getID() {
        return ID;
    }

    public int getNo() {
        return No;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
