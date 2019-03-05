package test;


import com.westos.service.RoleService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRoleDao {
    static ClassPathXmlApplicationContext context;
    static RoleService roleService;
    static {
        context=new ClassPathXmlApplicationContext("spring.xml");
        roleService = context.getBean(RoleService.class);
    }
    @Test
    public void findAll(){
        roleService.findAll();
    }
    @Test
    public void byid(){
        roleService.findByUserId(2);
    }

}
