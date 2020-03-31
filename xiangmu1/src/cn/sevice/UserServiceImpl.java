package cn.sevice;

import cn.dao.UserDao;
import cn.dao.UserDaoImpl;
import cn.don.PageBean;
import cn.don.User;
import cn.don.Users;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public Users findUsernameAndPassword(Users users) {
        return dao.findUAndP(users.getUsername(),users.getPassword());
    }

    @Override
    public void addUser(User user) {
         dao.adduser(user);
    }

    @Override
    public List<User> userAll() {
        return dao.findAll();
    }

    @Override
    public User findByid(String id) {
        return dao.findId(Integer.parseInt(id));
    }

    @Override
    public void deleteUser(String id) {
        dao.deUser(Integer.parseInt(id));
    }

    @Override
    public void deleteUsers(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.deUser(Integer.parseInt(id));
            }
        }
    }



    @Override
    public void updatepassword(String newpassword) {
        dao.updatePassword(Integer.parseInt(newpassword));
    }

    @Override
    public PageBean<User> findUserPageAndCondition(String c_currentPage, String c_rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(c_currentPage);
        int rows = Integer.parseInt(c_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        //创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }


}
