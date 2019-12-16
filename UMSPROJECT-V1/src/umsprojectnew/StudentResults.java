package umsprojectnew;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentResults {

    private double totalGpa;
    private ArrayList<Double> StudentGrade = new ArrayList<>();
    private double TotalGrades = 0;
    private int StudentId;
    private double totalPoints = 0;
    private ArrayList<String> letterGpa = new ArrayList<>();
    private ArrayList<Double> points = new ArrayList<>();
    public Scanner in = new Scanner(System.in);
    public StudentResults() {

    }
    public void showResult(int Studentposition, ArrayList<Student> student) {

        System.out.println("Name : " + student.get(Studentposition).getName()
                + "\tId : " + student.get(Studentposition).getId());
        int size = letterGpa.size();
        for (int j = 0; j < size; j++) {
            System.out.println("Course Name : " + "student.get(Studentposition).getStudentcourse().get(j)"
                    + "\t" + letterGpa.get(j)
                    + "\t" + points.get(j));
        }
        System.out.println("total Gpa : " + totalGpa
                + "\t\t Total Hours : " + student.get(Studentposition).getStudentCreditHours());
    }
    public void addCoursesgrades(ArrayList<Student> student, int studentposition) {
        double Grade;
        StudentId = student.get(studentposition).getId();
        if (!student.get(studentposition).getStudentcourse().isEmpty()) {
            int size = student.get(studentposition).getStudentcourse().size();
            for (int i = 0 ; i <size ; i++) {
                System.out.println("enter Grade to Course " + student.get(studentposition).getStudentcourse().get(i));
                Grade = in.nextDouble();
                StudentGrade.add(i,Grade);
                TotalGrades += Grade;
                System.out.println("grade to '" + student.get(studentposition).getStudentcourse().get(i) + "' has been added");
            }
//                    for (double d :StudentGrade ){
//                        System.out.println(d);
//                    }

        }

        calculateGpa(student, studentposition);
        calculatePointsAndletter();
    }
    public void calculateGpa(ArrayList<Student> student, int i) {
        for (double sum : points) {
            totalPoints += sum;
        }
        totalGpa = totalPoints / student.get(i).getStudentCreditHours();
    }
    public void calculatePointsAndletter() {
        for (int i = 0; i < StudentGrade.size(); i++) {
            if (StudentGrade.get(i) >= 93) {
                letterGpa.add(i,"A+");
                points.add(i,4.0);
            } else if (StudentGrade.get(i) < 93 && StudentGrade.get(i) > 85) {
                letterGpa.add(i,"A");
                points.add(i,3.75);
            } else if (StudentGrade.get(i) <= 85 && StudentGrade.get(i) > 80) {
                letterGpa.add(i,"B+");
                points.add(i,3.40);
            } else if (StudentGrade.get(i) <= 80 && StudentGrade.get(i) > 75) {
                letterGpa.add(i,"B");
                points.add(i,3.0);
            } else if (StudentGrade.get(i) <= 75 && StudentGrade.get(i) > 70) {
                letterGpa.add(i,"C+");
                points.add(i,2.75);
            } else if (StudentGrade.get(i) <= 70 && StudentGrade.get(i) > 65) {
                letterGpa.add("C");
                points.add(i,2.4);
            } else if (StudentGrade.get(i) <= 65 && StudentGrade.get(i) > 60) {
                letterGpa.add(i,"D+");
                points.add(i,2.25);
            } else if (StudentGrade.get(i) <= 60 && StudentGrade.get(i) > 50) {
                letterGpa.add(i,"D");
                points.add(i,2.0);
            } else if (StudentGrade.get(i) < 50) {
                letterGpa.add(i,"F");
                points.add(i,0.0);
            }
        }

    }
    public ArrayList<Double> getStudentGrade() {
        return StudentGrade;
    }
    public void setStudentGrade(ArrayList<Double> StudentGrade) {
        this.StudentGrade = StudentGrade;
    }
    public double getTotalGpa() {
        return totalGpa;
    }
    public void setTotalGpa(double totalGpa) {
        this.totalGpa = totalGpa;
    }
    public ArrayList<String> getLetterGpa() {
        return letterGpa;
    }
    public void setLetterGpa(ArrayList<String> letterGpa) {
        this.letterGpa = letterGpa;
    }

    public ArrayList<Double> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Double> points) {
        this.points = points;
    }

   
   
    public double getTotalGrades() {
        return TotalGrades;
    }
    public void setTotalGrades(double TotalGrades) {
        this.TotalGrades = TotalGrades;
    }
    public double getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }
    public int getStudentId() {
        return StudentId;
    }
    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }
}
