package dao;

import entity.Account;

import java.util.List;

public interface AccountDao {
    int add(Account account);
    int del(int id);
    int upd(Account account);
    Account selectById(int id);
    List<Account> selectAll();
    int count();
    int lessBalance(int id,int money);
    int addBalance(int id,int money);
}
