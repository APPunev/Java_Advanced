package SetsAndMapsAdvanced;
import java.util.*;

public class EXR_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> logMap = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ipAddress = input[0];
            String user = input[1];
            int time = Integer.parseInt(input[2]);

            if (logMap.containsKey(user)) {
                if (logMap.get(user).containsKey(ipAddress)) {
                    int currentTime = logMap.get(user).get(ipAddress);
                    logMap.get(user).put(ipAddress, currentTime + time);
                }else{
                    logMap.get(user).put(ipAddress, time);
                }
            } else{
                logMap.put(user, new TreeMap<>());
                logMap.get(user).put(ipAddress, time);
            }
        }
        logMap.entrySet()
                .forEach(en -> {
                    TreeMap<String, Integer> currentMap = en.getValue();
                    Set<String> currentSet = en.getValue().keySet();
                    int result = 0;
                    for (Map.Entry<String, Integer> entry:currentMap.entrySet()) {
                        result += entry.getValue();
                    }
                    System.out.println(en.getKey() + ": " + result + " " + currentSet);
                });
    }
}
