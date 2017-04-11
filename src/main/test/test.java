import entity.gm_goods;
import lombok.extern.slf4j.Slf4j;
import mapper.GoodMapper;
import mapper.goodsmapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2017/4/7.
 */
@Slf4j
public class test  {
    public static void main(String[] str){
        String resource = "mybatis.xml";
        InputStream is=null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Integer i=1003;
        GoodMapper gmapper = session.getMapper(GoodMapper.class);
        gm_goods goods = gmapper.QueryGoodsById(i);
        System.out.println(goods);
        goodsmapper gapper = session.getMapper(goodsmapper.class);
        gm_goods goodsm = gapper.QueryGoodsById(i);
        System.out.println(goodsm);
    }
}
