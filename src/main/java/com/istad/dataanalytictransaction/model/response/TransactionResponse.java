package com.istad.dataanalytictransaction.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private int id;
    private int sender_id;
    private int receiver_id;
    private double amount;
    private String remark;
    private String transfer_at;
}
