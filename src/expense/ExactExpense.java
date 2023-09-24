package expense;

import split.Split;
import users.User;

import java.math.BigDecimal;
import java.util.List;

public class ExactExpense extends Expense {

    ExactExpense(User paidBy, BigDecimal amount, List<Split> splitList) {
        super(ExpenseType.EXACT, paidBy);
        this.amount = amount;
        this.splits = splitList;
    }

}
