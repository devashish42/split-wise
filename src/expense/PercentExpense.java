package expense;

import expense.Expense;
import expense.ExpenseType;
import split.Split;
import users.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PercentExpense extends Expense {
    PercentExpense(User user){
        super(ExpenseType.PERCENT, user);
    }

    PercentExpense(User paidBy, BigDecimal amount, List<Split> splitList) {
        super(ExpenseType.EXACT, paidBy);
        this.amount = amount;
        for(Split s: splitList){
            BigDecimal splitAmount =  amount.multiply(s.getWeightage()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN);
            s.setAmount(splitAmount);
        }
        this.splits = splitList;
    }
}
