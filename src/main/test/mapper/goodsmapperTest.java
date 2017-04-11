package mapper;

import entity.gm_goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.mybatisUtil;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2017/4/11.
 */
public class goodsmapperTest {
    SqlSession session;
    @Before
    public void setUp() {
        String str="mybatis.xml";
        mybatisUtil mb=new mybatisUtil();
        session = mb.getsession(str);
    }

    @After
    public void tearDown(){
        session.close();
    }

    @Test
    public void queryGoodsById(){
        Integer i=1003;
        goodsmapper gmapper = session.getMapper(goodsmapper.class);
        gm_goods goods = gmapper.QueryGoodsById(i);
        System.out.println(goods);
    }
    @Test
    public void queryGoodsByGoodsId(){
        gm_goods goods = new gm_goods();
        goods.setId(1003);
        goodsmapper goodMapper=session.getMapper(goodsmapper.class);
        goods=goodMapper.QueryGoodsByGoodsId(goods);
        System.out.println(goods);
    }
    @Test
    public void QueryGoodsLike(){
        gm_goods goods = new gm_goods();
        goods.setGoodsname("洗");
        goodsmapper goodMapper=session.getMapper(goodsmapper.class);
        List<gm_goods> goodsList=goodMapper.QueryGoodsLike(goods);
        System.out.println(goodsList);
    }
    @Test
    public void QueryGoodsLimit(){
        goodsmapper goodMapper=session.getMapper(goodsmapper.class);
        List<gm_goods> goodsList=goodMapper.QueryGoodsLimit(Integer.valueOf(5));
        System.out.println(goodsList);
    }
}