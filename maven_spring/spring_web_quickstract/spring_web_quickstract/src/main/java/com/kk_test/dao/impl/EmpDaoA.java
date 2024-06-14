package com.kk_test.dao.impl;

import com.kk_test.dao.EmpDao;
import com.kk_test.pojo.Emp;
import com.kk_test.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ EmpDaoA :
 * @ Description:
 */

//@Component
@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        //1.controller 加载并解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
