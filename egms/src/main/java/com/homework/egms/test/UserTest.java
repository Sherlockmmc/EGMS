package com.homework.egms.test;
import com.homework.egms.bean.User;
import com.homework.egms.service.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: egms
 * @description:
 * @Author: Sherlock
 * @Date 2020/6/22 22:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    UserServiceImp userService;
    @Test
    public  void test1(){
        User user=new User();
        user.setUserName("小红7");
        user.setUserId((long)1027);
        user.setBirthday(new Date());
        user.setFamilyId((long)1);
        user.setPassword("222");
        user.setSex("女");
        userService.addUser(user);
    }
    @Test
    public  void test2(){
        userService.deletUser((long)1021);
    }
    @Test
    public  void test3(){
        User user= userService.findById((long)1023);
        System.out.println(user.toString());
    }
    @Test
    public  void test4(){}
    @Test
    public  void test5(){}
    @Test
    public  void test6(){}
}
