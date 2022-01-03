package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeSet;

public class LAB_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        TreeSet<String> guestList = new TreeSet<>();

        while(!command.equals("PARTY")){
            guestList.add(command);
            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while(!command.equals("END")){
            guestList.remove(command);
            command = scanner.nextLine();
        }

        System.out.println(guestList.size());
        System.out.println(String.join(System.lineSeparator(), guestList));
    }
}
