package mybatis;

import bean.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

public class Test {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }
    @org.junit.Test
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("hu");
        user.setAge(13);
        user.setRegTime(new Date());
        int id =  mapper.insertUser(user);
        System.out.println(user.getId());
    }
    @org.junit.Test
    public void batchInsertTest(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = new ArrayList<>();

        for(int i = 1 ;i<=10;i++){
            User user = new User();
            user.setAge(i);
            user.setName(String.valueOf(i));
            user.setRegTime(new Date());
            list.add(user);
        }
        for (User user1:list){
            System.out.println(user1.toString());
        }
        mapper.batchInsertUsers(list);
        for (User user1:list){
            System.out.println(user1.toString());
        }
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
//       User user = session.selectOne("mapper.UserMapper.selectUser",1);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("hu");
        user.setAge(13);
        user.setRegTime(new Date());
        int id =  mapper.insertUser(user);
        System.out.println("insert id "+id);
        System.out.println("insert id "+user.getId());
        session.commit();

        session.close();
        System.out.println(user.toString());
    }



}
