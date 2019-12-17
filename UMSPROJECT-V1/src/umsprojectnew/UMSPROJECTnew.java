package umsprojectnew;

import java.io.IOException;
import java.util.ArrayList;

public class UMSPROJECTnew {

    public static void main(String[] args) throws IOException {
        Admin a = new Admin();
        Ui Ui = new Ui();
        boolean flag = false;
        while (flag == false) {
            if (a.validating() == true) {
                flag = true;
                System.out.println("good . loged in");
                Ui.mainMenu();
            } else {
                System.err.println("try again ");
            }

        }

    }

}
