package umsprojectnew;

import java.util.Scanner;

public class Doctor extends Person {

//    private String DoctorId;
//    private String DoctorName;
    private String DoctorSpecialization;
    private int DoctorRoom;
    public Scanner input = new Scanner(System.in);

    public Doctor() {

    }

    public void addDoctor() {

        System.out.print("id:-");
        id = input.nextInt();

        System.out.print("name:-");
        name = input.nextLine();

        System.out.print("specilization:-");
        DoctorSpecialization = input.nextLine();

        System.out.print("room no.:-");
        DoctorRoom = input.nextInt();
    }

    public void showDoctorInfo() {
        System.out.println(id + "\t" + name + "\t" + DoctorSpecialization
                + "\t" + DoctorRoom);
    }

  

    public String getDoctorSpecialization() {
        return DoctorSpecialization;
    }

    public void setDoctorSpecialization(String DoctorSpecialization) {
        this.DoctorSpecialization = DoctorSpecialization;
    }

    public int getDoctorRoom() {
        return DoctorRoom;
    }

    public void setDoctorRoom(int DoctorRoom) {
        this.DoctorRoom = DoctorRoom;
    }


}
