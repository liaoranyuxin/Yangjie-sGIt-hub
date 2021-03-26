package userdaotest;
import dao.userdao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.user;
import utils.mybatisUtils;

import java.util.HashMap;
import java.util.List;

public class userdaotest {
@Test
    public void test(){
   SqlSession sqlSession=mybatisUtils.getSqlsession();
    userdao mapper = sqlSession.getMapper(userdao.class);
    List<user> getuserlist = mapper.getuserlist();
    for (user user : getuserlist) {
        System.out.println(user);
    }
    sqlSession.close();
}
@Test
public void getuserbyid(){
    SqlSession sqlSession=mybatisUtils.getSqlsession();
    userdao mapper = sqlSession.getMapper(userdao.class);
    user getuserbyid = mapper.getuserbyid(2);
    System.out.println(getuserbyid);
    sqlSession.close();
}
@Test
public void addUser(){
    SqlSession sqlSession=mybatisUtils.getSqlsession();
    userdao mapper = sqlSession.getMapper(userdao.class);
    mapper.adduser(new user(4,"何健","1997"));
    sqlSession.commit();
    sqlSession.close();
}

@Test
public void updateUser(){
    SqlSession sqlSession=mybatisUtils.getSqlsession();
    userdao mapper = sqlSession.getMapper(userdao.class);
    mapper.update(new user(2,"heping","842096181"));
    sqlSession.commit();
    sqlSession.close();
}
    @Test
    public void deleteUser(){
        SqlSession sqlSession=mybatisUtils.getSqlsession();
        userdao mapper = sqlSession.getMapper(userdao.class);
        mapper.delete(2);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        SqlSession sqlSession=mybatisUtils.getSqlsession();
        userdao mapper = sqlSession.getMapper(userdao.class);
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("id",38);
        map.put("name","何健的爷爷");
        map.put("pwd","456789");
        mapper.adduser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getuserbyid2(){
        SqlSession sqlSession=mybatisUtils.getSqlsession();
        userdao mapper = sqlSession.getMapper(userdao.class);
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("id",15);
        user user = mapper.getuserbyid2(map);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getuserlike(){
        SqlSession sqlSession=mybatisUtils.getSqlsession();
        userdao mapper = sqlSession.getMapper(userdao.class);
        List<user> he = mapper.getuserlike("%何%");
        for (user user : he) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}


