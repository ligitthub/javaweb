package cn.sevice;

import cn.don.PageBean;
import cn.don.User;
import cn.don.Users;

import java.util.List;
import java.util.Map;

public interface UserService {
    Users findUsernameAndPassword(Users users);

    void addUser(User user);

    List<User> userAll();

    User findByid(String id);

    void deleteUser(String id);

    void deleteUsers(String[] ids);

    void updatepassword(String newpassword);

    PageBean<User> findUserPageAndCondition(String currentPage, String rows, Map<String, String[]> condition);


    void updateUser(User user);
}
