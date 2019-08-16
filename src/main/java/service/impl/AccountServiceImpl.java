package service.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.transaction.annotation.Transactional;
import service.AccountService;

import java.util.List;
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> queryAll() {
        return accountDao.selectAll();
    }

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int upd(Account account) {
        return accountDao.upd(account);
    }

    @Override
    public int del(int id) {
        return accountDao.del(id);
    }

    @Override
    public Account selectById(int id) {
        return accountDao.selectById(id);
    }

    @Override
    public int count() {
        return accountDao.count();
    }

    @Override
    public void accountBalance(int id1, int id2, int money) {
        accountDao.lessBalance(id1,money);
        accountDao.addBalance(id2,money);
    }
}
