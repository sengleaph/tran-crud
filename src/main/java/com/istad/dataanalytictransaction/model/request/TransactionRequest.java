package com.istad.dataanalytictransaction.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotBlank(message = "Sender_account_id is required!!!")
    private int sender_account_id;
    @NotBlank(message = "Receiver_account_id is required!!!")
    private int receiver_account_id;
    private double amount;
    private String remark;
    private String transfer_at;
}
