package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LAB_Voina_NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> first = readInput(scanner.nextLine());
        LinkedHashSet<Integer> second = readInput(scanner.nextLine());

        int count = 50;

        while(count-- > 0){
            int firstPlayerCard = getFirstCard(first);
            int secondPlayerCard = getFirstCard(second);

            first.remove(firstPlayerCard);
            second.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                first.add(firstPlayerCard);
                first.add(secondPlayerCard);
            }else if (secondPlayerCard > firstPlayerCard){
                second.add(firstPlayerCard);
                second.add(secondPlayerCard);
            }

            if (first.isEmpty() || second.isEmpty()) {
                break;
            }
        }

        if (first.size() > second.size()) {
            System.out.println("First player win!");
        }else if (second.size() > first.size()) {
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }

    private static int getFirstCard(LinkedHashSet<Integer> set) {
        return set.stream().findFirst().orElse(0);
    }

    private static LinkedHashSet<Integer> readInput(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
