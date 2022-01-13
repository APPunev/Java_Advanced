package FunctionalProgramming;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EXR_10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while (!(input = scanner.nextLine()).equals("Party!")) {
            String[] token = input.split("\\s+");
            String doubleOrRemove = token[0];
            String criteria = token[1];
            String value = token[2];

            Predicate<String> filter = filterNames(criteria, value);

            if (doubleOrRemove.equals("Remove")) {
                names.removeIf(filter);
            } else {
                List<String> namesToAdd = getNames(filter, names);
                for (String name : namesToAdd) {
                    names.add(name);
                }
            }
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.print(String.join(", ", names));
            System.out.print(" are going to the party!");
        }
    }

    private static List<String> getNames(Predicate<String> filter, List<String> names) {
        List<String> list = new ArrayList<>();
        for (String name : names) {
            if (filter.test(name)) {
                list.add(name);
            }
        }
        return list;
    }

    private static Predicate<String> filterNames(String filter, String value) {
        if (filter.equals("StartsWith")) {
            return str -> str.startsWith(value);
        } else if (filter.equals("EndsWith")) {
            return str -> str.endsWith(value);
        }
        return str -> str.length() == Integer.parseInt(value);
    }
}
