package expense;

import split.Split;
import users.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class EqualExpense extends Expense {

    EqualExpense(User user) {
        super(ExpenseType.EQUAL, user);
    }


    EqualExpense(User paidBy, BigDecimal amount, List<Split> splitList) {
        super(ExpenseType.EQUAL, paidBy);

        int size = splitList.size();
        BigDecimal indAmount = amount.divide(new BigDecimal(size), RoundingMode.HALF_EVEN);

        for(Split s : splitList){
            s.setAmount(indAmount);
        }

        this.amount = amount;
        this.splits = splitList;
    }

}
