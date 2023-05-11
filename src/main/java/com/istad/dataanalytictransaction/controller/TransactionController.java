package com.istad.dataanalytictransaction.controller;

import com.github.pagehelper.PageInfo;
import com.istad.dataanalytictransaction.model.Transaction;
import com.istad.dataanalytictransaction.model.request.TransactionRequest;
import com.istad.dataanalytictransaction.service.TransactionService;
import com.istad.dataanalytictransaction.utils.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;


    @GetMapping("/getAllTransactions")
    public Response<PageInfo<Transaction>> getAllTransactions(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size, @RequestParam(defaultValue = "", required = false)String filterName){
        try {
            PageInfo<Transaction> tran = transactionService.getAllTransactions(page, size, filterName);
            return Response.<PageInfo<Transaction>>ok().setPayload(tran).setMessage("Your Transactions are all Successfully retrieved!!!!!");
        }catch (Exception e){
            return Response.<PageInfo<Transaction>>exception().setMessage("Your Transactions are Failed to retrieved !!!!! Exception Occurs");
        }
    }

    @PostMapping("/Create-NewTransaction")
    public Response<Transaction> createNewTransaction (@Valid @RequestBody TransactionRequest trequest){
        try {
            int newTransaction = transactionService.createNewTransaction(trequest);
            if (newTransaction>0){
                Transaction tran = new Transaction().setId(newTransaction).setSender_account_id(trequest.getSender_account_id()).setReceiver_account_id(trequest.getReceiver_account_id()).setAmount(trequest.getAmount()).setRemark(trequest.getRemark()).setTransfer_at(trequest.getTransfer_at());
                return Response.<Transaction>createSuccess().setPayload(tran).setMessage("Your Transaction is Successfully create new one");
            }else
                return Response.<Transaction>badRequest().setMessage("Bad Request!!!! You are Failed to create new Transaction");
        }catch (Exception e){
            return Response.<Transaction>exception().setMessage("Exception Occurs!!!! Can not defined new Transaction");
        }
    }

    @PutMapping("/updateTransaction/{id}")
    public Response<Transaction> updateTransaction(@RequestBody TransactionRequest trequest, @PathVariable("id")int id){
        try{
            int updateTran = transactionService.updateTransaction(trequest,id);
            if (updateTran>0){
                Transaction tran = new Transaction().setId(id).setSender_account_id(trequest.getSender_account_id()).setReceiver_account_id(trequest.getReceiver_account_id()).setAmount(trequest.getAmount()).setRemark(trequest.getRemark()).setTransfer_at(trequest.getTransfer_at());
                return Response.<Transaction>ok().setPayload(tran).setMessage("You are Successfully update your Transaction via ID!!!!").setSuccess(true);
            }else
                return Response.<Transaction>notFound().setMessage("Undefined Your ID = "+id+"to update!!!!").setSuccess(false);
        }catch (Exception e){
            return Response.<Transaction>exception().setMessage("Exception Occurs!!!! Failed to Update your Transaction");
        }
    }

    @DeleteMapping("deleteTransaction/{id}")
    public Response<?> deleteTransactionById(@PathVariable int id){
        try {
            int deleteTran = transactionService.deleteTransactionById(id);
            if (deleteTran>0){
                return Response.<Transaction>deleteSuccess().setMessage("Your Transaction is Successfully removed!!!").setSuccess(true);
            }else
                return Response.<Transaction>notFound().setMessage("Undefined Your Transaction Id = "+id+"to removed");
        }catch (Exception e){
            return Response.<Transaction>exception().setMessage("Exception Occurs!!!!Failed to remove the Transaction").setSuccess(false);
        }
    }
}