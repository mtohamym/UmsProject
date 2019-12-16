package umsprojectnew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public Scanner in = new Scanner(System.in);
    ArrayList<Student> csStudents = new ArrayList<>();
    ArrayList<Course> csCourse = new ArrayList<>();
    ArrayList<Doctor> csDoctors = new ArrayList<>();
    ArrayList<StudentResults> csStudentResults = new ArrayList<>();

    public void mainMenu() throws IOException {
        getDataStudent();
        getDataCourse();
        getDataDcotors();
        getResultsData();
        System.out.println("\tUNIVERSTY MANAGEMENT SYsTEM");
        int choice, status = 1;
        while (status == 1) {

            System.out.println("\nMAIN MENU");

            System.out.println("--------------------------------------------------");

            System.out.println("1.STUDENT  2.COURSES  3.STUDENT RESULTS  4.DOCTORS  5.EXIT");

            System.out.println("--------------------------------------------------");

            choice = in.nextInt();

            switch (choice) {

                case 1: {
                    studentSection();
                    break;

                }

                case 2: {
                    courseSection();

                    break;
                }

                case 3: {
                    resultsSection();
                    break;
                }

                case 4: {
                    doctorSection();
                    break;
                }
                case 5: {
                    System.exit(0);
                }

            }

        }

    }

    public void studentSection() {

        int choice, Select = 1;

        System.out.println("\t\t\t\t\t**STUDENT SECTION**");
        System.out.println("--------------------------------------------------------------------------------");
        while (Select == 1) {

            System.out.println("1.Add Student\n2.Student list\n3.Register course\n4.Show Studnts enrroled course.");
            try {

                choice = in.nextInt();

                switch (choice) {

                    case 1: {
                        //add student
                        csStudents.add(new Student());
                        csStudents.get(csStudents.size() - 1).addStudent();
                        storeDataStudent();
                        break;

                    }

                    case 2: {
                        //Student list
                        String FileHeader = "name\tid\tStudentSSN\tStudentAddres\tStudentBDate,";
                        System.out.println(FileHeader);
                        for (int i = 0; i < csStudents.size(); i++) {
                            csStudents.get(i).showInfo();
                        }
                        break;
                    }

                    case 3: {
                        //Register course
                        System.out.println("enter srudent id");
                        int id = in.nextInt();
                        int i = searchStudent(id);

                        if (i != -1) {
                            csStudents.get(i).registrationCourse(csCourse);
                        } else {
                            System.out.println("not found Student ! .. Try again!");
                        }

                        //can put try and catch here .
                        break;
                    }
                    case 4: {
                        //4.Show Studnts enrroled course.

                        for (int i = 0; i < csStudents.size(); i++) {
                            csStudents.get(i).showStudentsenrroled();
                        }
                        break;

                    }

                }
            } catch (IOException e) {
                System.out.println("e");
            }
            try {
                System.out.println("1-student section\n2-Main menu ");

                Select = in.nextInt();
            } catch (Exception e) {
                System.out.println("input valid");
            }

        }
    }

    public void courseSection() {
        try {

            int choice, Select = 1;

            System.out.println("\t\t\t\t\t**COURSE SECTION**");
            System.out.println("--------------------------------------------------------------------------------");
            while (Select == 1) {

                System.out.println("1.Add Course\n2.Course list\n3.Search cource\n4.delete cource");

                choice = in.nextInt();

                switch (choice) {

                    case 1: {
                        //Add Course
                        csCourse.add(new Course());
                        csCourse.get(csCourse.size() - 1).addCourse();
                        storeDataCourse();
                        break;

                    }

                    case 2: {
                        // Course list
                        for (int i = 0; i < csCourse.size(); i++) {
                            csCourse.get(i).showInfo();
                        }
                        break;
                    }

                    case 3: {
                        //search cource
                        int i = searchCource();
                        csCourse.get(i).showInfo();
                        break;
                    }
                    case 4: {
                        //delete cource
                        int i = searchCource();
                        csCourse.remove(i);
                        storeDataCourse();
                        break;
                    }

                }
                System.out.println("1-Course section\n2-Main menu ");

                Select = in.nextInt();

            }
        } catch (Exception e) {
            System.out.println("input error");
        }
    }
//toto
    public void doctorSection() {
        try {
            int text ;
            int choice, Select = 1;

            System.out.println("\t\t\t\t\t**Doctor SECTION**");
            System.out.println("--------------------------------------------------------------------------------");
            while (Select == 1) {

                System.out.println("1.Add Doctor\n2.Doctor list");

                choice = in.nextInt();

                switch (choice) {

                    case 1: {
                        //Add Doctor
                        csDoctors.add(new Doctor());
                        csDoctors.get(csDoctors.size() - 1).addDoctor();
                        storeDataDcotors();
                        break;

                    }

                    case 2: {
                        // Doctor list
                        for (int i = 0; i < csDoctors.size(); i++) {
                            csDoctors.get(i).showDoctorInfo();
                        }
                        break;
                    }

                }
                System.out.println("1-Doctor section\n2-Main menu ");

                Select = in.nextInt();

            }
        } catch (Exception e) {
            System.out.println("input error");
        }
    }

    public void resultsSection() throws IOException {

        int choice, Select = 1;

        System.out.println("\t\t\t\t\t**Results SECTION**");
        System.out.println("--------------------------------------------------------------------------------");
        while (Select == 1) {

            System.out.println("1.Add result \n2.result by id");

            choice = in.nextInt();

            switch (choice) {

                case 1: {
                    //Add result
                    csStudentResults.add(new StudentResults());
                    System.out.println("enter srudent id");
                    int id = in.nextInt();
                    int studentPosition = searchStudent(id);
                    if (studentPosition != -1) {
                        csStudentResults.get(csStudentResults.size() - 1).addCoursesgrades(csStudents, studentPosition);
                    } else {
                        System.out.println("not found student");
                    }
                    storeDataResults();
                    break;

                }

                case 2: {
                    // show results by id
                    System.out.println("enter srudent id");
                    int id = in.nextInt();
                    int studentPosition = searchStudent(id);
                    int gradePosition = searchResult(id);
                    if (studentPosition != -1) {
                        csStudentResults.get(gradePosition).showResult(studentPosition, csStudents);
                    } else {
                        System.out.println("not found student");
                    }

                    break;
                }

            }
            System.out.println("1-results section\n2-Main menu ");

            Select = in.nextInt();
        }
    }

    public int searchStudent(int id) {

        int i;
        boolean flag = false;

        for (i = 0; i < csStudents.size(); i++) {
            if (id == csStudents.get(i).getId()) {
                flag = true;
                System.out.println("found");
                break;
            }
        }

        //if  
        if (flag == true) {
            return i;
        } else {
            return -1;
        }
    }

    public int searchCource() {
        int id;
        int i;
        boolean flag = false;
        System.out.println("enter cource id");
        id = in.nextInt();
        for (i = 0; i < csCourse.size(); i++) {
            if (id == csCourse.get(i).getCode()) {
                flag = true;

                break;
            }
        }
        if (flag == true) {
            System.out.println("Cource found");
            return i;
        } else {
            System.out.println("Cource not found");

            return -1;
        }
    }

    public int searchResult(int id) {

        int i;
        boolean flag = false;
        for (i = 0; i < csStudentResults.size(); i++) {
            if (id == csStudentResults.get(i).getStudentId()) {
                flag = true;

                break;
            }
        }
        if (flag == true) {
            System.out.println("grages found");
            return i;
        } else {
            System.out.println("grades not added to this id");

            return -1;
        }
    }

    public void storeDataStudent() throws IOException {
        String Comma = ",";
        String newLine = "\n";
        String FileHeader = "name\t,id\t,StudentSSN\t,StudentAddres\t,StudentBDate,";
        try (FileWriter student = new FileWriter("D:\\StudentData.Csv")) {
            student.append(FileHeader);
            for (int i = 0; i < csStudents.size(); i++) {
                student.append(newLine);
                student.append(csStudents.get(i).getName());
                student.append(Comma);
                student.append(String.valueOf(csStudents.get(i).getId()));
                student.append(Comma);
                student.append(csStudents.get(i).getStudentSSN());
                student.append(Comma);
                student.append(csStudents.get(i).getStudentAddres());
                student.append(Comma);
                student.append(csStudents.get(i).getStudentBDate());
                student.append(Comma);
                student.append(newLine);
                student.flush();

            }
        }

    }

    public void getDataStudent() throws IOException {
        String File = "D:\\StudentData.Csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(File));
            String Line = "";
            reader.readLine();
            while ((Line = reader.readLine()) != null) {
                //mohammed,2020,10th,2212,20-4-2000
                String[] text = Line.split(",");
                if (text.length > 3) {
                    Student s = new Student();
                    s.setName(text[0]);
                    s.setId(Integer.parseInt(text[1]));
                    s.count = s.getId() + 1;
                    s.setStudentSSN(text[2]);
                    s.setStudentAddres(text[3]);
                    s.setStudentBDate(text[4]);
                    csStudents.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Not found file!!");
        }

    }

    public void storeDataCourse() throws IOException {
        String Comma = ",";
        String newLine = "\n";
        String FileHeader = "Course Name\t,code\t,credit_hour\t,max_grade\t,type,";
        try (FileWriter student = new FileWriter("D:\\CourseData.Csv")) {
            student.append(FileHeader);
            for (int i = 0; i < csCourse.size(); i++) {
                student.append(newLine);
                student.append(csCourse.get(i).getName());
                student.append(Comma);
                student.append(String.valueOf(csCourse.get(i).getCode()));
                student.append(Comma);
                student.append(String.valueOf(csCourse.get(i).getCredit_hour()));
                student.append(Comma);
                student.append(String.valueOf(csCourse.get(i).getMax_grade()));
                student.append(Comma);
                student.append(csCourse.get(i).getType());
                student.append(Comma);
                student.append(newLine);
                student.flush();

            }
        }

    }

    public void getDataCourse() throws IOException {
        String File = "D:\\CourseData.Csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(File));
            String Line = "";
            reader.readLine();
            while ((Line = reader.readLine()) != null) {
                String[] text = Line.split(",");
                if (text.length > 3) {
                    Course c = new Course();
                    c.setName(text[0]);
                    c.setCode(Integer.parseInt(text[1]));
                    c.count = c.getCode() + 1;
                    c.setCredit_hour(Integer.parseInt(text[2]));
                    c.setMax_grade(Integer.parseInt(text[3]));
                    c.setType(text[4]);
                    csCourse.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Course file Not found!!");
        }

    }

    public void storeDataResults() throws IOException {
        String Comma = ",";
        String newLine = "\n";
        String FileHeader = "StudentId\t,totalPoints\t,totalGpa\t,totalGrades\t,number of LetterGpa";
        try (FileWriter student = new FileWriter("D:\\StudentResults.Csv")) {
            student.append(FileHeader);
            for (int i = 0; i < csStudentResults.size(); i++) {
                student.append(newLine);
                student.append(String.valueOf(csStudentResults.get(i).getStudentId()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getTotalPoints()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getTotalGpa()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getTotalGrades()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getLetterGpa().size()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getPoints().size()));
                student.append(Comma);
                student.append(String.valueOf(csStudentResults.get(i).getStudentGrade().size()));
                student.append(Comma);
                for (int j = 0; j < csStudentResults.get(i).getLetterGpa().size(); j++) {
                    student.append(String.valueOf(csStudentResults.get(i).getStudentGrade().get(j)));
                    student.append(Comma);
                    student.append(String.valueOf(csStudentResults.get(i).getLetterGpa().get(j)));
                    student.append(Comma);
                    student.append(String.valueOf(csStudentResults.get(i).getPoints().get(j)));
                    student.append(Comma);
                }
                student.append(newLine);
                student.flush();

            }
        }

    }

    public void getResultsData() throws IOException {
        String File = "D:\\StudentResults.Csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(File));
            String Line = "";
            reader.readLine();
            ArrayList<String> letterGpa = new ArrayList<>();
            ArrayList<Double> points = new ArrayList<>();
            ArrayList<Double> StudentGrade = new ArrayList<>();

            while ((Line = reader.readLine()) != null) {
                String[] text = Line.split(",");
                if (text.length > 3) {
                    StudentResults s = new StudentResults();
                    s.setStudentId(Integer.parseInt(text[0]));
                    s.setTotalPoints(Double.parseDouble(text[1]));
                    s.setTotalGpa(Double.parseDouble(text[2]));
                    s.setTotalGrades(Double.parseDouble(text[3]));
                    int count = Integer.parseInt(text[4]);
                    for (int i = 7; i < text.length; i++) {
                        StudentGrade.add(Double.parseDouble(text[i]));
                        letterGpa.add(text[(++i)] + "");
                        double x = Double.parseDouble(text[(++i)]);
                        points.add(x);
                    }
                    s.setStudentGrade(StudentGrade);
                    s.setLetterGpa(letterGpa);
                    s.setPoints(points);
                    csStudentResults.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Course file Not found!!");
        }

    }

    public void storeDataDcotors() throws IOException {
        String Comma = ",";
        String newLine = "\n";
        String FileHeader = "id\t,name\t,specilization\t,room no,";
        try (FileWriter Dcotor = new FileWriter("D:\\DoctorData.Csv")) {
            Dcotor.append(FileHeader);
            for (int i = 0; i < csDoctors.size(); i++) {
                Dcotor.append(newLine);
                Dcotor.append(String.valueOf(csDoctors.get(i).getId()));
                Dcotor.append(Comma);
                Dcotor.append(csDoctors.get(i).getName());

                Dcotor.append(Comma);
                Dcotor.append(csDoctors.get(i).getDoctorSpecialization());
                Dcotor.append(Comma);
                Dcotor.append(String.valueOf(csDoctors.get(i).getDoctorRoom()));
                Dcotor.append(Comma);
                Dcotor.append(newLine);
                Dcotor.flush();

            }
        }

    }

    public void getDataDcotors() throws IOException {
        String File = "D:\\DoctorData.Csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(File));
            String Line = "";
            reader.readLine();
            while ((Line = reader.readLine()) != null) {
                //id\t,name\t,specilization\t,room no,
                String[] text = Line.split(",");
                if (text.length > 3) {
                    Doctor s = new Doctor();
                    s.setName(text[0]);
                    s.setId(Integer.parseInt(text[1]));
                    s.setDoctorSpecialization(text[2]);
                    s.setDoctorRoom(Integer.parseInt(text[3]));
                    csDoctors.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Not found file!!");
        }

    }
}
