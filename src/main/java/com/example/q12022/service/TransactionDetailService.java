package com.example.q12022.service;

import com.example.q12022.domain.TransactionDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TransactionDetailService {
    TransactionDetail saveTransactionDetail(TransactionDetail dto);
}
