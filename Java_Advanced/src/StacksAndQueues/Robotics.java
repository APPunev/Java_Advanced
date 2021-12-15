package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");

        LinkedHashMap<String, Integer> robotsMap = getRobotsMap(input);
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(input);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getStartTimeInSeconds(startTime);

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String product = scanner.nextLine();
        while(!product.equals("End")){
            productsQueue.offer(product);
            product = scanner.nextLine();
        }

        while(!productsQueue.isEmpty()){
            String currentProduct = productsQueue.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            for (Map.Entry<String,Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {

                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(),robotsMap.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken) {
                productsQueue.offer(currentProduct);
            }

        }
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String,Integer>robot:robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) {
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] input) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : input) {
            String robotName = robot.split("-")[0];

            robots.put(robotName,0);
        }
        return robots;
    }

    private static int getStartTimeInSeconds(String startTime) {
        int hour = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hour * 3600 + minutes * 60 + seconds;
    }

    private static String getStartTime(int startTimeInSeconds){
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;

        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }

    private static LinkedHashMap<String, Integer> getRobotsMap (String[] input)  {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : input) {
            String robotName = robot.split("-")[0];
            int processTime = Integer.parseInt(robot.split("-")[1]);

            robots.put(robotName,processTime);
        }
        return robots;
    }
}
