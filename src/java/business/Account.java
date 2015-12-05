/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Account implements Serializable {
    
    public enum Type {
        CHECKING, SAVINGS;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    private double balance;
    @ManyToOne
    @JoinColumn(name="id")
    private User user;
    @ManyToOne
    private List<Transaction> transactions;
    
    
    public Account() {
    
    }

    public Account(Type type, double balance, User user) {
        this.balance = balance;
        this.user = user;
        this.type = type;
        this.transactions = new ArrayList<Transaction>();
    }
    
    public void credit(double amount){
        balance += amount;
        this.transactions.add(new Transaction(this, amount, Transaction.transactionTypes.CREDIT));
    }
    public void debit(double amount){
        balance -= amount;
        this.transactions.add(new Transaction(this, amount, Transaction.transactionTypes.DEBIT));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}