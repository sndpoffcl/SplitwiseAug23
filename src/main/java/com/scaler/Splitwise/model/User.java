package com.scaler.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany
    private List<Group> groups;
}

/*
    User - Group : M:M -> Bidirectional
    User - UserExpense : 1:M ->


    Expense
       paid : A=100, B=100    { we want to know how much each user has
       spent or has to spend, we want to know the amount and user from each userExpense object}
       hasToPay : A=50, B=50, C=100
 */