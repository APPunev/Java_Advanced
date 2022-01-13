package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EXR_11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> leftoverList = new ArrayList<>();

        String command = scanner.nextLine();

        while(!command.equals("Print")){
            String[] tokens = command.split(";");

            String action = tokens[0];
            String filter = tokens[1];
            String value = tokens[2];

            Predicate<String> filterNames = getFilter(filter,value);

            if (action.equals("Add filter")) {
                names.stream().filter(filterNames).forEach(leftover -> leftoverList.add(leftover));
                names.removeIf(filterNames);
            }else{
                leftoverList.stream().filter(filterNames).forEach(leftover -> names.add(leftover));
            }
            command = scanner.nextLine();
        }
        System.out.print(String.join(" ", names));
    }


    private static Predicate<String> getFilter(String filter, String value) {
        if (filter.equals("Starts with")) {
            return str -> str.startsWith(value);
        }else if (filter.equals("Ends with")) {
            return str -> str.endsWith(value);
        }else if (filter.equals("Contains")) {
            return str -> str.contains(value);
        }
        return str -> str.length() == Integer.parseInt(value);
    }
}
