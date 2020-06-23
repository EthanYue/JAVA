package com.netease.day04.jdbc;

import com.netease.util.DruidUtils;
import com.netease.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.lang.annotation.Inherited;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplate {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        String updateSql = "update account set money=? where username=?";
        int cnt = template.update(updateSql, 5000, "yuefeiyu");
        System.out.println(cnt);

        String insertSql = "insert into account(username, money) values(?,?)";
        int cnt2 = template.update(insertSql, "yuefeiyu", 6000);
        System.out.println(cnt2);

        String removeString = "delete from account where username=?";
        int cnt3 = template.update(removeString, "yuefieyu");
        System.out.println(cnt3);

        String selectSql = "select * from account where username=?";
        Map<String, Object> res = template.queryForMap(selectSql, "allenyue"); // queryForMap method return length is just one;
        System.out.println(res);

        List<Map<String, Object>> res1 = template.queryForList(selectSql, "yuefeiyu");
        System.out.println(res1);

        List<Account> res2 = template.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(res2);

        Long aLong = template.queryForObject("select count(1) from account", Long.class); // queryForObject method is used to agg function;
        System.out.println(aLong);

    }
}


class Account {
    private String username;
    private Integer money;

    public Account() {
    }

    public Account(String username, int money) {
        this.username = username;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}