package util;

import lombok.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.*;

/**
 * Created by admin on 2017/4/8.
 */
public class mybatisUtil {
    private SqlSessionFactory factory;
    private SqlSession session;
    private InputStream stream=null;
    public SqlSession getsession(String resource){
        try {
            stream= getResourceAsStream(resource);
            factory=new SqlSessionFactoryBuilder().build(stream);
            //true自动提交false手动提交需要在调用方法里添加session.commit();
            session = factory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
