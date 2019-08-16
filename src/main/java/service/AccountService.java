package service;

import entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> queryAll();
    int add(Account account);
    int upd(Account account);
    int del(int id);
    Account selectById(int id);
    int count();
    void accountBalance(int id1,int id2,int money);
}
