package com.istad.dataanalytictransaction.mapper;

import com.istad.dataanalytictransaction.model.Transaction;
import com.istad.dataanalytictransaction.model.response.TransactionResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface TransactionMapper {
    List<TransactionResponse> mapToTransactionResponse(List<Transaction> transactions);
    List<Transaction> mapToTransaction(List<TransactionResponse> transactionResponses);
}
