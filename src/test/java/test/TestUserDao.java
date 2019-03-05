package test;

import com.westos.domain.User;

import com.westos.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    static ClassPathXmlApplicationContext context;
    static UserService userService;
    static {
        context=new ClassPathXmlApplicationContext("spring.xml");
        userService = context.getBean(UserService.class);
    }

    @Test
    public void insert (){
        User user = new User();
        user.setId(168);
        user.setUsername("我最帅");
        user.setPassword("123");

        userService.insert(user);
    }
}
