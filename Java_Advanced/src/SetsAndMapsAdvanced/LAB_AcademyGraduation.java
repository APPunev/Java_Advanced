package SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class LAB_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            studentMap.put(scanner.nextLine(), new ArrayList<>(readArray(scanner.nextLine())));
        }
        studentMap.entrySet()
                .forEach(el->{
                    System.out.print(el.getKey() + " is graduated with ");
                    List<Double> currentList = el.getValue();
                    System.out.print(currentList
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .average().getAsDouble());
                    System.out.println();
                });
    }

    public static List<Double> readArray(String line){
        return Arrays.stream(line.split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
