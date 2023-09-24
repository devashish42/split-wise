package users;

import expense.Expense;
import split.Split;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class User {

    String id;

    String name;

    String phoneNumber;

    String email;

    ArrayList<Expense> expenses;


    public User(String userId) {
        this.id = userId;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense e){
        this.expenses.add(e);
    }

    public void showExpenses() {
        System.out.println("Showing Expenses \n");
        for (Expense e: expenses) {
            System.out.println( e.getPaidBy().id + " Paid " + e.getAmount() + "\n");
            for(Split s: e.getSplits()) {
                if(!Objects.equals(s.getUser().id, this.id))
                    System.out.println( s.getUser().id + " Owes " + this.id + " " + s.getAmount() + "\n");
            }
        }

    }

}
