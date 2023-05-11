package com.istad.dataanalytictransaction.repository;

import com.istad.dataanalytictransaction.model.Transaction;
import com.istad.dataanalytictransaction.model.request.TransactionRequest;
import com.istad.dataanalytictransaction.repository.provider.TransactionProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Mapper
public interface TransactionRepository {
    @SelectProvider(type = TransactionProvider.class, method = "getAllTransactions")
    List<Transaction> getAllTransactions(String filterName);

    @InsertProvider(type = TransactionProvider.class, method = "createNewTransaction")
    int createNewTransaction(@Param("transaction") TransactionRequest trequest);

    @UpdateProvider(type = TransactionProvider.class, method = "updateTransaction")
    int updateTransaction(@PathVariable("transaction")TransactionRequest trequest, int id);

    @DeleteProvider(type = TransactionProvider.class, method = "deleteTransactionById")
    int deleteTransactionById(@Param("id")int id);

}
