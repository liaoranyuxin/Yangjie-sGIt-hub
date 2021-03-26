package dao;

import pojo.user;

import java.util.List;
import java.util.Map;

public interface userdao {
    ///查询全表
    List<user> getuserlist();
    ///查询通过id
    user getuserbyid(int id);
    user getuserbyid2(Map<String,Object> map);
    //insert into添加
    int adduser (user user);
    int update (user user);
    int delete(int id);
    int adduser2(Map<String,Object> map);
    List <user> getuserlike(String name);

}
