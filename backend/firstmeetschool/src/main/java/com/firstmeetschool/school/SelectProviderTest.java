package com.firstmeetschool.school;

import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.mapper.DynamicProviderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SelectProviderTest {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(reader);
        SqlSession session = sqlSessionFactory.openSession();
        session.getConfiguration().addMapper(DynamicProviderMapper.class);
        DynamicProviderMapper mapper = session.getMapper(DynamicProviderMapper.class);

        User user = mapper.findUserById("1");
        System.out.println(user.toString());
//        System.out.println(user.getUsrName());
//        System.out.println(user.getUsrAge());
//        System.out.println(user.getUsrId());
//        System.out.println(user.getUsrEducation());
//        System.out.println(user.getUsrSex());
//        System.out.println(user.getUsrTelephone());
        session.commit();
        session.close();

    }

}
