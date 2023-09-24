package expense;

import split.Split;
import users.User;

import java.math.BigDecimal;
import java.util.List;

public abstract class Expense {

    User paidBy;

    public User getPaidBy() {
        return paidBy;
    }

    BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    ExpenseType type;

    public ExpenseType getType() {
        return type;
    }

    List<Split> splits;

    public List<Split> getSplits() {
        return splits;
    }

    Expense(ExpenseType type, User user) {
        this.type = type;
        this.paidBy = user;
    }

    public Expense(User user, BigDecimal amount, List<Split> splitList, ExpenseType type) {
        this.type = type;
        this.paidBy = user;
        this.amount = amount;
        this.splits = splitList;
    }
}
