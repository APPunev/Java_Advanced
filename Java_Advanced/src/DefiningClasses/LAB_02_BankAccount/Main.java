package DefiningClasses.LAB_02_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<Integer, BankAccount> accountMap = new HashMap<>();

        String output = null;

        while(!(input = scanner.nextLine()).equals("End")){
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

//            if (idNotValid(tokens, accountMap)) {
//                System.out.println("Account does not exist");
//                continue;
//            }

            if (command.endsWith("Create")) {
                BankAccount bankAccount = new BankAccount();
                accountMap.put(bankAccount.getId(),bankAccount);
                output = String.format("Account ID%d created",bankAccount.getId());
            }else if (command.endsWith("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = accountMap.get(id);
                output = executeIfNotNull(bankAccount, b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d",amount,id);
                });
            }else if (command.endsWith("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                continue;
            }else {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);
                BankAccount bankAccount = accountMap.get(id);
                output = executeIfNotNull(bankAccount, b -> {
                    double interest = b.getInterest(years);
                    return String.format("%.2f", interest);
                });
            }

            if (output != null) {
                System.out.println(output);
            }
        }
    }

//    private static boolean idNotValid(String[] tokens, Map<Integer, BankAccount> accountMap) {
//        boolean validID = false;
//        if (tokens[0].equals("Deposit") || tokens[0].equals("GetInterest")) {
//            if (!accountMap.containsKey(Integer.parseInt(tokens[1]))) {
//                validID = true;
//            }
//        }
//        return validID;
//    }

    public static String executeIfNotNull(BankAccount account, Function<BankAccount, String> function){
        if (account == null) {
            return "Account does not exist";
        }

        return function.apply(account);
    }


}
