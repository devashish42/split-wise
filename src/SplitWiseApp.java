import expense.ExpenseService;
import users.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class SplitWiseApp {

    public static void main (String[] args) throws Exception {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");

        HashMap<String, User> userIdToUser = new HashMap<String, User>();
        userIdToUser.put("u1", u1);
        userIdToUser.put("u2", u2);
        userIdToUser.put("u3", u3);
        userIdToUser.put("u4", u4);

        ExpenseService expenseService = new ExpenseService();
        System.out.println("Starting SPlit wise App, enter inputs from next line \n");


        while(true) {
            Scanner sc= new Scanner(System.in);
            String in = sc.nextLine();
            String[] inputAsList = in.split(" ");
            String firstWord = inputAsList[0];
            if(Objects.equals(firstWord, "EXPENSE")) {
                expenseService.addExpense(in, userIdToUser);
            }
            else if (Objects.equals(firstWord, "SHOW") && Arrays.stream(inputAsList).count() == 1) {
                System.out.println("no balance");
            }
            else  {
                String userId = inputAsList[1];
                userIdToUser.get(userId).showExpenses();

            }
        }

    }
}
