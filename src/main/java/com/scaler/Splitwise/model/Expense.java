package com.scaler.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @OneToMany
    List<UserExpense> userExpenses;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
}
/*
      Expense : UserExpense -> 1:M { uni-directional on expense side}
      Group : Expense -> 1:M { uni-directional on group side }


{
    "description": "Dinner",
    "amount": 1000,
    "group": 1,
    "currency": "INR",
    "userExpenses": [
        {
            "name" : "Rituraj",
            "amount" : 500,
            "userExpenseType" : "paid"
        },
        {
            "name" : "Omkar",
            "amount" : 500,
            "userExpenseType" : "paid"
        },
        {
            "name" : "A",
            "amount" : 250,
            "userExpenseType" : "hasToPay"

        } ]
}

 */