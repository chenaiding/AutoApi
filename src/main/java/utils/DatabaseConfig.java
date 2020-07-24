package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author chenaiding
 * Created on 2020/7/23.
 */
public class DatabaseConfig {

        public static SqlSession getSqlsession() throws IOException {

            //获取配置资源文件
            Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            //sqlSession就是能够执行配置文件中的sql语句
            SqlSession sqlSession=factory.openSession();
            return sqlSession;
        }
    }

