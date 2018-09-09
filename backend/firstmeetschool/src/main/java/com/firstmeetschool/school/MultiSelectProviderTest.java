package com.firstmeetschool.school;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.mapper.DynamicProviderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiSelectProviderTest {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        session.getConfiguration().addMapper(DynamicProviderMapper.class);
        DynamicProviderMapper mapper = session.getMapper(DynamicProviderMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("usrSex", "男");
//        map.put("isStudent", "是");
        map.put("usrEducation", "硕士");
        map.put("lowAge", 23);
        map.put("highAge", 26);
//        Integer lowAge = 20;
//        Integer highAge = 30;
        List<User> students = mapper.findUserInHomePage(map);
        int count = 0;
        for (User student : students) {
            System.out.println("number:" + count);
            System.out.println(student.toString());
            count++;
        }
        session.commit();
        session.close();
    }

}
