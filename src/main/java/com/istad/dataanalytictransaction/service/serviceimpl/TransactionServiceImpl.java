package com.istad.dataanalytictransaction.service.serviceimpl;

import com.istad.dataanalytictransaction.model.Transaction;
import com.istad.dataanalytictransaction.model.request.TransactionRequest;
import com.istad.dataanalytictransaction.repository.TransactionRepository;
import com.istad.dataanalytictransaction.service.TransactionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    
    private final TransactionRepository transactionRepository;
    @Override
    public PageInfo<Transaction> getAllTransactions(int page, int size, String filterName) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(transactionRepository.getAllTransactions(filterName));
    }

    @Override
    public int createNewTransaction(TransactionRequest transactionRequest) {
        return transactionRepository.createNewTransaction(transactionRequest);
    }

    @Override
    public int deleteTransactionById(int id) {
        return transactionRepository.deleteTransactionById(id);
    }

    @Override
    public int updateTransaction(TransactionRequest transactionRequest, int id) {
        return transactionRepository.updateTransaction(transactionRequest, id);
    }
}
