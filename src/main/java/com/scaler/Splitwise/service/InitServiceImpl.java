package com.scaler.Splitwise.service;

import com.scaler.Splitwise.model.*;
import com.scaler.Splitwise.repository.ExpenseRepository;
import com.scaler.Splitwise.repository.GroupRepository;
import com.scaler.Splitwise.repository.UserExpenseRepository;
import com.scaler.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Override
    public void initialise() {
        User omkar = User.builder()
                        .email("omkar@email.com")
                                .phoneNumber("1234567890")
                                        .name("Omkar Oak")
                                                .build();

        User rahul = User.builder()
                .email("rahul@email.com")
                .phoneNumber("2234567890")
                .name("Rahul Raushan")
                .build();

        User deepan = User.builder()
                .email("deepan@email.com")
                .phoneNumber("3234567890")
                .name("Deepan")
                .build();

        User bhakti = User.builder()
                .email("bhakti@email.com")
                .phoneNumber("4234567890")
                .name("Bhakti Shah")
                .build();

        rahul = userRepository.save(rahul);
        omkar = userRepository.save(omkar);
        deepan = userRepository.save(deepan);
        bhakti = userRepository.save(bhakti);

        Group group = new Group();
        group.setDescription("Friends who never pay back on time");
        group.setName("Trip to Manali");
        group.setUsers(List.of(rahul, omkar, deepan, bhakti));

        group =  groupRepository.save(group);

        //4 expenses
        //Expense 1 -> amount 1000, paid By : Omkar, hasTopay : everyone equal
        UserExpense userExpense = new UserExpense();
        userExpense.setUser(omkar);
        userExpense.setAmount(1000);
        userExpense.setUserExpenseType(UserExpenseType.PAID);
        userExpense = userExpenseRepository.save(userExpense);

        UserExpense userExpense1 = new UserExpense();
        userExpense1.setUser(omkar);
        userExpense1.setAmount(250);
        userExpense1.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense1 = userExpenseRepository.save(userExpense1);

        UserExpense userExpense2 = new UserExpense();
        userExpense2.setUser(rahul);
        userExpense2.setAmount(250);
        userExpense2.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense2 = userExpenseRepository.save(userExpense2);

        UserExpense userExpense3 = new UserExpense();
        userExpense3.setUser(bhakti);
        userExpense3.setAmount(250);
        userExpense3.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense3 = userExpenseRepository.save(userExpense3);

        UserExpense userExpense4 = new UserExpense();
        userExpense4.setUser(deepan);
        userExpense4.setAmount(250);
        userExpense4.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense4 = userExpenseRepository.save(userExpense4);

        Expense expense = new Expense();
        expense.setAmount(1000);
        expense.setDescription("Dinner");
        expense.setCurrency(Currency.INR);
        expense.setUserExpenses(List.of(userExpense, userExpense1, userExpense2, userExpense3, userExpense4));

        expenseRepository.save(expense);
    }
}
