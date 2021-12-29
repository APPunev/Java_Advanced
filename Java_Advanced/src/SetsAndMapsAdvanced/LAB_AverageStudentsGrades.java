package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LAB_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            if (studentsGrades.containsKey(name)) {
                studentsGrades.get(name).add(grade);
            }else{
                studentsGrades.put(name, new ArrayList<>());
                studentsGrades.get(name).add(grade);
            }
        }

        studentsGrades.entrySet().forEach(el->{
            System.out.print(el.getKey() + " -> ");
            List<Double> current = el.getValue();
            current.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)",getAverage(el.getValue()));
            System.out.println();
        });
    }

    private static double getAverage(List<Double> value) {
        double sum = 0;
        for (double e : value) {
            sum += e;
        }
        return sum/value.size();
    }
}
