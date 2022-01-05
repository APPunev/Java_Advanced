package SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EXR_LegendaryFarming {

    public class LegendaryFarming {
        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);

            Map<String, Integer> farming = new TreeMap<>();
            Map<String, Integer> legendary = new TreeMap<>();
            legendary.put("shards", 0);
            legendary.put("fragments", 0);
            legendary.put("motes", 0);
            Map<String, Integer> junk = new TreeMap<>();

            boolean toBreak = false;


            while (true) {
                String[] items = scanner.nextLine().toLowerCase().split(" ");

                for (int i = 0; i < items.length - 1; i++) {
                    if (items[i + 1].equals("shards")
                            || items[i + 1].equals("motes")
                            || items[i + 1].equals("fragments")) {
                        if (farming.containsKey(items[i + 1])) {
                            int currentQty = farming.get(items[i + 1]);
                            int newQty = Integer.parseInt(items[i]);
                            if (newQty + currentQty >= 250) {
                                farming.put(items[i + 1], currentQty + newQty - 250);
                                legendary.put(items[i + 1], currentQty + newQty - 250);
                                if (items[i + 1].equals("shards")) {
                                    System.out.println("Shadowmourne obtained!");
                                } else if (items[i + 1].equals("fragments")) {
                                    System.out.println("Valanyr obtained!");
                                } else if (items[i + 1].equals("motes")) {
                                    System.out.println("Dragonwrath obtained!");
                                }
                                toBreak = true;
                                break;
                            } else {
                                farming.put(items[i + 1], currentQty + newQty);
                                legendary.put(items[i + 1], currentQty + newQty);
                            }
                        } else {
                            int newQty = Integer.parseInt(items[i]);

                            if (newQty >= 250) {
                                farming.put(items[i + 1], newQty - 250);
                                legendary.put(items[i + 1], newQty - 250);
                                if (items[i + 1].equals("shards")) {
                                    System.out.println("Shadowmourne obtained!");
                                } else if (items[i + 1].equals("fragments")) {
                                    System.out.println("Valanyr obtained!");
                                } else if (items[i + 1].equals("motes")) {
                                    System.out.println("Dragonwrath obtained!");
                                }
                                toBreak = true;
                                break;
                            } else {
                                farming.put(items[i + 1], Integer.parseInt(items[i]));
                                legendary.put(items[i + 1], Integer.parseInt(items[i]));
                            }
                        }
                    } else {
                        if (farming.containsKey(items[i + 1])) {
                            int currentQty = farming.get(items[i + 1]);
                            int newQty = Integer.parseInt(items[i]);
                            farming.put(items[i + 1], newQty + currentQty);
                            junk.put(items[i + 1], newQty + currentQty);
                        } else {
                            farming.put(items[i + 1], Integer.parseInt(items[i]));
                            junk.put(items[i + 1], Integer.parseInt(items[i]));
                        }
                    }
                    i++;
                }
                if (toBreak) {
                    break;
                }
            }

            legendary.entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue()
                                    .reversed()
                                    .thenComparing(Map.Entry.comparingByKey()))
                                    .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));


            junk.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        }
    }
}