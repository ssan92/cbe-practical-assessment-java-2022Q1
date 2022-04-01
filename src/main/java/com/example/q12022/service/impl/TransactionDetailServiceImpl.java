package com.example.q12022.service.impl;

import com.example.q12022.domain.TransactionDetail;
import com.example.q12022.repository.TransactionDetailRepository;
import com.example.q12022.service.TransactionDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionDetailServiceImpl implements TransactionDetailService {

    private final TransactionDetailRepository transactionDetailRepository;

    @Override
    public TransactionDetail saveTransactionDetail(TransactionDetail dto) {
        return transactionDetailRepository.save(dto);
    }
}
