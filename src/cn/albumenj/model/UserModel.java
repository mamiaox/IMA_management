package cn.albumenj.model;

/**
 * @author Albumen
 */
public class UserModel {
    private int No;
    private int ID;
    private String password;
    private String name;
    private String phone;
    private String qq;
    private int department;
    private int permission;

    public UserModel(){
        No = 0;
        ID = 0;
        password = "";
        name = "";
        phone = "";
        qq = "";
        department = 0;
        permission = 0;
    }

    public int getDepartment() {
        return department;
    }

    public int getID() {
        return ID;
    }

    public int getNo() {
        return No;
    }

    public int getPermission() {
        return permission;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getQq() {
        return qq;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNo(int no) {
        No = no;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public boolean isChairman() {
        return permission == 1;
    }

    public boolean isAdmin() {
        return ( permission == 1 || permission == 2 );
    }
}
