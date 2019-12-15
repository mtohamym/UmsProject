package umsprojectnew;

import java.util.Scanner;

public class Course {
    public static int count = 1;
    private  int code = count;
    private String name;
    private int credit_hour;
    private int max_grade;
    private String type;
    public Scanner in = new Scanner(System.in);

    public void editCourse() {

    }

    public String searchCourse(int code) {
        return null;
    }

    public void storeData() {

    }

    public void getData() {

    }

    public void addCourse() {
        count++;
        System.out.println("enter course name : ");
        name = in.nextLine();
        
        System.out.println("course code is : " + (code ));
        
        System.out.println("enter course credit hour : ");
        credit_hour = in.nextInt();

        System.out.println("enter course max grade : ");
        max_grade = in.nextInt();
        
        System.out.println("enter course  type : ");
        type = in.next();

        System.out.println("Done .. the course have been added . ");
    }

    public void showInfo() {
        System.out.println(name + "\t" + code + "\t" + credit_hour + "\t" + max_grade + "\t" + type);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit_hour() {
        return credit_hour;
    }

    public void setCredit_hour(int credit) {
        this.credit_hour = credit_hour;
    }

    public int getMax_grade() {
        return max_grade;
    }

    public void setMax_grade(int max) {
        this.max_grade = max_grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
