package com.istad.dataanalytictransaction.repository.provider;


import com.istad.dataanalytictransaction.model.request.TransactionRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;


public class TransactionProvider{
    public static String getAllTransactions(String filterName){
        return new SQL(){{
            SELECT("*");
            FROM("transaction_tb");
            if (!filterName.isEmpty()){
                WHERE("sender_account_id=#{filterName}");
            }
        }}.toString();
    }
    public static String updateTransaction(TransactionRequest transactionRequest, @Param("id")int id){
        return new SQL(){{
            UPDATE("transaction_tb");
            SET("sender_account_id = #{sender_account_id}");
            SET("receiver_account = #{receiver_account}");
            SET("amount = #{amount}");
            SET("remark = #{remark}");
            SET("transfer_at = #{transfer_at}");
            WHERE("id = #{id}");
        }}.toString();
    }
    public static String createNewTransaction(TransactionRequest transactionRequest){
        return new SQL(){{
            INSERT_INTO("transaction_tb");
            VALUES("sender_account_id","#{sender_account_id}");
            VALUES("receiver_account_id","#{receiver_account_id}");
            VALUES("amount","#{amount}");
            VALUES("remark","#{remark}");
            VALUES("transfer_at","#{transfer_at}");
        }}.toString();
    }
    public static String deleteTransactionById(@Param("id")int id){
        return new SQL(){{
            DELETE_FROM("transaction_tb");
            WHERE("id = #{id}");
        }}.toString();
    }
}
