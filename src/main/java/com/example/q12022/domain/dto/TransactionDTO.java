package com.example.q12022.domain.dto;

import com.example.q12022.domain.TransactionDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class TransactionDTO {

    private Long id;
    private Long storeId;
    private Long customerId;
    private Date date;
    private Double total;

    private List<TransactionDetail> detail;

    public TransactionDTO() {
        detail = new ArrayList<>();
        total = 0.0;
    }
}
