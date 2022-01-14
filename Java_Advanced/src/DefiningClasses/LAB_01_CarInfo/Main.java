package DefiningClasses.LAB_01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            Car car;
            if (token.length == 1) {
                car = new Car(token[0]);
            }else{
                car = new Car(token[0], token[1], Integer.parseInt(token[2]));
            }

            carList.add(car);
        }

        System.out.println(carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator()))); //Принтиране на цолекция, която не е от Стринг с делиметър ", " - Collectors.joining(", ")
    }
}
