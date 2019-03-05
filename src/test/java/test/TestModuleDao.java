package test;


import com.westos.domain.Module;
import com.westos.service.Impl.RoleServiceImpl;
import com.westos.service.ModuleService;
import com.westos.service.RoleService;
import com.westos.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestModuleDao {
    static ClassPathXmlApplicationContext context;
    static {
       context =
                new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findAll(){
        ModuleService moduleService = context.getBean(ModuleService.class);
        List<Module> all = moduleService.findAll();
        System.out.println("..");
//        for (Module module : all) {
//            System.out.println(module.getName());
//        }

    }
    @Test
    public void findByRoleid(){
        ModuleService moduleService = context.getBean(ModuleService.class);
        moduleService.findByRoleId(2);
    }

    @Test
    public void mmodifymodule(){
        int[] ints = {1,2};
        RoleService bean = context.getBean(RoleService.class);
        bean.modifyRoleModule(1,ints);
    }


}
