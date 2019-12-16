package umsprojectnew;

import java.util.Scanner;

public class Admin {

    private String Adminuser;
    private String Adminpassword;

    public Scanner in = new Scanner(System.in);

    public Admin() {
        Adminuser = "admin";
        Adminpassword = "ums";

    }

    public boolean validating() {
        String user;
        String password;
        System.out.println("enter your user");
        user = in.next();
        System.out.println("enter your password");
        password = in.next();
        if (user.equals(Adminuser) && password.equals(Adminpassword)) {
            return true;

        } else {
            return false;
        }
    }

    public void storeData() {
    }
     public void getData() {
    }

    public void setUser(String user) {
        this.Adminuser = user;
    }

    public void setPassword(String password) {
        this.Adminpassword = password;
    }

    public String getUser() {
        return Adminuser;
    }

    public String getPassword() {
        return Adminpassword;
    }

}
