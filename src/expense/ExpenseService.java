package expense;

import split.Split;
import users.User;

import java.math.BigDecimal;
import java.util.*;

public class ExpenseService {

    public void addExpense(String expenseInput, HashMap<String, User> userIdToUser) throws Exception {
        String[] inputAsList = expenseInput.split(" ");

        String userId = inputAsList[1];
        BigDecimal totalAmount = new BigDecimal(inputAsList[2]);
        User user = userIdToUser.get(userId);
        int numUsersIndex = 3;
        int numberOfUsers = Integer.parseInt(inputAsList[3]);
        ExpenseType type = ExpenseType.valueOf(inputAsList[numUsersIndex+ numberOfUsers + 1]);
        ArrayList<Split> splitList = new ArrayList<>();
        for(int i=numUsersIndex+1; i<=numUsersIndex+numberOfUsers;i++){
            Split s = new Split();
            String uId = inputAsList[i];
            s.setUser(userIdToUser.get(uId));
            if(type != ExpenseType.EQUAL) {
                s.setWeightage(new BigDecimal(inputAsList[numberOfUsers+1+i]));
            }
            splitList.add(s);
        }

        ExpenseFactory factory = new ExpenseFactory(type);
        Expense e = factory.createExpense(user, totalAmount, splitList);
        user.addExpense(e);
    }
}

