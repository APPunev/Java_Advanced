package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentPage = "";
        while(!input.equals("Home")){
            if (input.equals("back")) {
                if (!browser.isEmpty()) {
                    currentPage = browser.pop();
                }else{
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            }else{
                if (!currentPage.equals("")) {
                    browser.push(currentPage);
                }
                currentPage = input;
            }
            System.out.println(currentPage);
            input = scanner.nextLine();
        }
    }
}
