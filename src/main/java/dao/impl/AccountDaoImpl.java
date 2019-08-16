package dao.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(Account account) {
        String sql="insert into account1(username,balance) values(?,?) ";
        int x=jdbcTemplate.update(sql,account.getUsername(),account.getBalance());
        return x;
    }

    @Override
    public int del(int id) {
        String sql="delete from account1 where id=?";
        int x=jdbcTemplate.update(sql,id);
        return x;
    }

    @Override
    public int upd(Account account) {
        String sql="update account1 set username=?,balance=? where id=?";
        int x=jdbcTemplate.update(sql,account.getUsername(),account.getBalance(),account.getId());
        return x;
    }

    @Override
    public Account selectById(int id) {
        String sql="select * from account1 where id=?";
        Account account=jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account1=new Account();
                account1.setId(resultSet.getInt("id"));
                account1.setUsername(resultSet.getString("username"));
                account1.setBalance(resultSet.getInt("balance"));
                return account1;
            }
        }, id);
        return account;
    }

    @Override
    public List<Account> selectAll() {
        String sql="select * from account1";
        List<Account> list=jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account=new Account();
                account.setId(resultSet.getInt("id"));
                account.setUsername(resultSet.getString("username"));
                account.setBalance(resultSet.getInt("balance"));
                return account;
            }
        });
        return list;
    }

    @Override
    public int count() {
        String sql="select count(*) from account1";
        int x=jdbcTemplate.queryForObject(sql,Integer.class);
        return x;
    }

    @Override
    public int lessBalance(int id,int money) {
        String sql="update account1 set balance=balance-? where id=?";
        int x=jdbcTemplate.update(sql,money,id);
        return x;
    }

    @Override
    public int addBalance(int id,int money) {
        String sql="update account1 set balance=balance+? where id=?";
        int x=jdbcTemplate.update(sql,money,id);
        return x;
    }
}
