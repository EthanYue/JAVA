package com.netease.day04.jdbc;

import com.netease.util.JDBCUtils;
import com.netease.util.MysqlUtils;

import java.sql.*;
import java.util.ArrayList;

public class Demo1 {
    public static void main(String[] args) throws Exception {

        int cnt1 = MysqlUtils.update("insert into roles values(null, 'test', 1, 255)");
        int cnt2 = MysqlUtils.update("update roles set `default`=0 where role_name='test'");
        int cnt3 = MysqlUtils.update("delete from roles where role_name='test'");

        if (cnt1 > 0 && cnt2 > 0 && cnt3 > 0) System.out.println("success");
        else System.out.println("fail");

        ResultSet resultSet = MysqlUtils.query("select * from roles");
        ArrayList<Role> roles = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("role_name");
            int _default = resultSet.getInt("default");
            int permission = resultSet.getInt("permissions");
            Role role = new Role(id, name, _default, permission);
            roles.add(role);
        }
        System.out.println(roles);
        MysqlUtils.close();
    }
}



class Role {
    private int id;
    private String role_name;
    private int _default;
    private int permission;

    public Role() {}

    public Role(int id, String role_name, int _default, int permission) {
        this.id = id;
        this.role_name = role_name;
        this._default = _default;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int get_default() {
        return _default;
    }

    public void set_default(int _default) {
        this._default = _default;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", _default=" + _default +
                ", permission=" + permission +
                '}';
    }
}


