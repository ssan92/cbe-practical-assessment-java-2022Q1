package com.example.q12022.service.impl;

import com.example.q12022.domain.Transaction;
import com.example.q12022.repository.ReportsRepository;
import com.example.q12022.repository.TransactionRepository;
import com.example.q12022.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction dto) {
        return transactionRepository.save(dto);
    }

}
