package project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterFace() throws IOException {
        Scanner scaner = new Scanner(System.in);

        while (true){
            System.out.println("Enter name of city ");
            String city = scaner.nextLine();
            System.out.println("1 -day or 5 day");
            String command = scaner.nextLine();

            if(command.equals("0")) break;

            controller.getWeather(command, city);
        }
    }
}
