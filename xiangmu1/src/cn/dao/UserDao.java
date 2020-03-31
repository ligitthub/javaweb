package cn.dao;

import cn.don.User;
import cn.don.Users;

import java.util.List;
import java.util.Map;

public interface UserDao {


    Users findUAndP(String username, String password);

    void adduser(User user);

    List<User> findAll();

    User findId(int id);

    void deUser(int id);

    void updatePassword(int parseInt);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    void update(User user);
}
