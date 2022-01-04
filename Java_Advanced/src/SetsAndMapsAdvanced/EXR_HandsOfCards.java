package SetsAndMapsAdvanced;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class EXR_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String , HashSet<String>> playerMap = new LinkedHashMap<>();
        String name = "";
        while (!input.equals("JOKER")){
            HashSet<String> cards = new HashSet<>();
            String[] tokens = input.split(": ");
            if (!tokens[0].contains(":")) {
                name = tokens[0];
                String cardsData = tokens[1];
                cards = readArray(cardsData);
                if (playerMap.containsKey(name)) {
                    HashSet<String>current=playerMap.get(name);
                    HashSet<String> murged = murgeSets(current,cards);
                    playerMap.put(name,murged);
                }else{
                    playerMap.put(name,cards);
                }
            }
            input = scanner.nextLine();
        }
        LinkedHashMap<String, Integer> finalMap = new LinkedHashMap<>();
        for (Map.Entry<String, HashSet<String>> entry:playerMap.entrySet()) {

            int result = 0;
            HashSet<String> currentSet = entry.getValue();
            for (String card:currentSet) {
                int number = 0;
                char c = 'a';
                if (Character.isDigit(card.charAt(0))) {
                    if (card.length() > 2) {
                        String str = card.substring(0,2);
                        number = Integer.parseInt(str);
                        c = card.charAt(2);
                    }else{
                        number = Integer.parseInt(String.valueOf(card.charAt(0)));
                        c = card.charAt(1);
                    }
                    switch (c){
                        case 'S':
                            result += number * 4;
                            break;
                        case 'H':
                            result += number * 3;
                            break;
                        case 'D':
                            result += number * 2;
                            break;
                        case 'C':
                            result += number * 1;
                            break;
                    }
                }else{
                    int cardValue = 0;

                    switch (card.charAt(0)){
                        case 'J':
                            cardValue = 11;
                            break;
                        case 'Q':
                            cardValue = 12;
                            break;
                        case 'K':
                            cardValue = 13;
                            break;
                        case 'A':
                            cardValue = 14;
                            break;
                    }
                    switch (card.charAt(1)){
                        case 'S':
                            result += cardValue * 4;
                            break;
                        case 'H':
                            result += cardValue * 3;
                            break;
                        case 'D':
                            result += cardValue * 2;
                            break;
                        case 'C':
                            result += cardValue * 1;
                            break;
                    }
                }
            }
            finalMap.put(entry.getKey(),result);
        }
        finalMap.entrySet().forEach(en -> System.out.println(en.getKey() + ": " + en.getValue()));
    }

    private static HashSet<String> murgeSets(HashSet<String> current, HashSet<String> cards) {
        HashSet<String> newSet = current;
        for (String card:cards) {
            newSet.add(card);
        }
        return newSet;
    }

    private static HashSet<String> readArray(String cardsData) {
        HashSet<String> set = new HashSet<>();
        String[]token = cardsData.split(", ");
        for (String da:token) {
            set.add(da);
        }
        return set;
    }
}
