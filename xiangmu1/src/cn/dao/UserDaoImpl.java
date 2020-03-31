package cn.dao;

import cn.don.User;
import cn.don.Users;
import cn.util.JDBCutil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCutil.getDs());

    @Override
    public Users findUAndP(String username, String password) {
        try {
            String sql="select * from user where username=? and password=?";
            Users users = template.queryForObject(sql, new BeanPropertyRowMapper<Users>(Users.class), username, password);
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void adduser(User user) {
        String sql="insert into user values(null,?,?,null,?,?,?,?)";
        template.update(sql,new BeanPropertyRowMapper<User>(User.class),user.getName(),user.getCorporate_name(),user.getTelephone(),user.getLandline(),user.getCompany_profile(),user.getRemarks());
    }

    @Override
    public List<User> findAll() {
        String sql="select * from user";
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findId(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void deUser(int id) {
        String sql="delete  from user where id=?";
        template.update(sql,id);
    }

    @Override
    public void updatePassword(int parseInt) {

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {

        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数
        params.add(start);
        params.add(rows);

        return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }

    @Override
    public void update(User user) {
        String sql="update user set name=?,corporate_name=?,telephone=?,landline=?,company_profile=?,remarks=? where id=?";
        template.update(sql,user.getName(),user.getCorporate_name(),user.getTelephone(),user.getLandline(),user.getCompany_profile(),user.getRemarks(),user.getId());
    }

}
