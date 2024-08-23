package model.entities;

import model.exceptions.BusinessException;

public class Account {
    private Integer numberAccount;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer numberAccount, String holder, Double balance, Double withdrawLimit) {
        this.numberAccount = numberAccount;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void withdraw(double withdraw) {
        if (withdrawLimit < withdraw) {
            throw new BusinessException("The amount exceeds withdraw limit");
        }
        if (balance < withdraw) {
            throw new BusinessException("Not enough balance");
        }
        this.balance -= withdraw;
    }
}
