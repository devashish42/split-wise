package split;

import users.User;

import java.math.BigDecimal;

public class Split {

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    BigDecimal weightage;

    public BigDecimal getWeightage() {
        return weightage;
    }

    public void setWeightage(BigDecimal weightage) {
        this.weightage = weightage;
    }

    BigDecimal amount;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
