package com.scaler.Splitwise.controller;

import com.scaler.Splitwise.dto.SettleUpResponseDTO;
import com.scaler.Splitwise.dto.TransactionDTO;
import com.scaler.Splitwise.model.User;
import com.scaler.Splitwise.service.GroupService;
import com.scaler.Splitwise.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {
    @Autowired
    private InitService initService;
    @Autowired
    private GroupService groupService;

    @GetMapping("/init") // GET call -> localhost:8080/hello
    public ResponseEntity initialise(){
        initService.initialise();
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/settleUp")
    public ResponseEntity settleUp(){
        List<TransactionDTO> transactionDTOS = groupService.settleUp();
        return ResponseEntity.ok(transactionDTOS);
    }
}
