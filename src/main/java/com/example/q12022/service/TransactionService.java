package com.example.q12022.service;

import com.example.q12022.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    Transaction saveTransaction(Transaction dto);
}
