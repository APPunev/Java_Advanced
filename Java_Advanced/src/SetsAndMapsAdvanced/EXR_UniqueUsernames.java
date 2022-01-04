package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class EXR_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> userSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String user = scanner.nextLine();

            userSet.add(user);
        }

        System.out.println(String.join(System.lineSeparator(), userSet));
    }
}
