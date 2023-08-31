package com.scaler.Splitwise.service;

import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    UserRepository userRepository; // ideal way should be to call a method in userService that calls the userRepository to get the users

    @Override
    public List<TransactionDTO> settleUp() {
        return null;
    }
}
