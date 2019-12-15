package umsprojectnew;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.*;
import java.io.*;

public class Student extends Person {
    
    public static int count = 1;
    
    private String StudentSSN;
    private String StudentAddres;
    private String StudentBDate;
    private int StudentCreditHours;
    private ArrayList<String> Studentcourse = new ArrayList<>();
    public Scanner in = new Scanner(System.in);
    
    public Student() {
        id = count;
        
    }
    
    public void addStudent() throws IOException {
        count++;
        System.out.println("\nenter Student name : ");
        name = in.nextLine();
        
        System.out.println("Student id is : " + id);
        
        System.out.println("enter Student ssn : ");
        in.nextLine();
        StudentSSN = in.nextLine();
        
        System.out.println("enter Student addres : ");
        in.nextLine();
        StudentAddres = in.nextLine();
        
        System.out.println("enter Student Birth Date : ");
        StudentBDate = in.next();
        
        System.out.println("\nDone .. the Student have been added . ");
    }
    
    public void showInfo() {
        System.out.println(name + "\t" + id + "\t" + StudentSSN
                + "\t" + StudentAddres + "\t" + StudentBDate);
    }
    
    public void registrationCourse(ArrayList<Course> course) throws IOException {
        int code;
        System.out.println("enter course code");
        code = in.nextInt();
        for (int i = 0; i < course.size(); i++) {
            if (code == course.get(i).getCode()) {
                Studentcourse.add(course.get(i).getName());
                StudentCreditHours += course.get(i).getCredit_hour();
                System.out.println(course.get(i).getName() + " course added");
                break;
            }
            
        }
        
    }
    
    public void showStudentsenrroled() {
        if (!Studentcourse.isEmpty()) {
            System.out.println("Name " + name + "\t" + "Id :" + id + "\t" + "Total Hours" + StudentCreditHours);
            for (String s : Studentcourse) {
                System.out.println(s + "\t");
                
            }
        }
        
    }
    
    
    
    public String getStudentSSN() {
        return StudentSSN;
    }
    
    public void setStudentSSN(String StudentSSN) {
        this.StudentSSN = StudentSSN;
        
    }
    
    public String getStudentAddres() {
        return StudentAddres;
    }
    
    public void setStudentAddres(String StudentAddres) {
        this.StudentAddres = StudentAddres;
    }
    
    public String getStudentBDate() {
        return StudentBDate;
    }
    
    public void setStudentBDate(String StudentBDate) {
        this.StudentBDate = StudentBDate;
    }
    
    public ArrayList<String> getStudentcourse() {
        return Studentcourse;
    }
    
    public void setStudentcourse(ArrayList<String> Studentcourse) {
        this.Studentcourse = Studentcourse;
    }
    
    public int getStudentCreditHours() {
        return StudentCreditHours;
    }
    
    public void setStudentCreditHours(int StudentCreditHours) {
        this.StudentCreditHours = StudentCreditHours;
    }
    
}
