package expense;

import split.Split;
import users.User;

import java.math.BigDecimal;
import java.util.List;

class ExpenseFactory {

    ExpenseType type;


    ExpenseFactory(ExpenseType type) {
        this.type = type;

    }

    Expense createExpense(User userId, BigDecimal amount, List<Split> splitList) throws Exception {

        if (type == ExpenseType.EQUAL) {
            return new EqualExpense(userId, amount, splitList);
        } else if (type == ExpenseType.PERCENT) {
            return new PercentExpense(userId, amount, splitList);
        } else if (type == ExpenseType.EXACT) {
            return new ExactExpense(userId, amount, splitList);
        } else
            throw new Exception("No mapping present");
    }
}
