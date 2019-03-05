package com.westos.service.Impl;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.westos.dao.ModuleDao;
import com.westos.domain.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements com.westos.service.ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public List<Module> findAll() {
//        System.out.println("module   findall================");
        //两层循环
        List<Module> modules = moduleDao.findAll();
        for (Module module : modules) {
            //父
            List<Module> modules1 = new ArrayList<>();
            for (Module module1 : modules) {
            //子
                //如果儿子的pid等于父亲的ID 就加入儿子的列表
                if(module.getId() == module1.getPid()){
                    modules1.add(module1);
                }
            }
            module.setChildren(modules1);
        }
        List<Module> list = new ArrayList<>();
        for (Module module : modules) {
            if(module.getPid()== 0){
                list.add(module);
            }
        }

//        for (Module module : modules) {
//            System.out.println(module.getName()+"================================================");
//            List<Module> list = module.getChildren();
//            for (Module module1 : list) {
//                System.out.print(module1.getName()+"   ");
//            }
//        }
//        System.out.println("modul    findall   ending==========");
        return list;
    }

    @Override
    public List<Module> findByRoleId(int roleId) {
        List<Module> modules = moduleDao.findByRoleId(roleId);
        return modules;
    }


}
