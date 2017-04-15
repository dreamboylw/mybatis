package mapper;

import entity.mybatisStudyOne;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.mybatisUtil;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2017/4/12.
 */
@Slf4j
public class MybatisStudyOneTest {
    SqlSession session;
    String str="mybatis.xml";
    @Before
    public void setUp() throws Exception {
        mybatisUtil mb=new mybatisUtil();
        session = mb.getsession(str);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void wueryMstudyList() throws Exception {
        mybatisStudyOne mso=new mybatisStudyOne();
        mso.setName("ddddd");
        MybatisStudyOne msomapper = session.getMapper(MybatisStudyOne.class);
         mso= msomapper.queryMstudyList(mso);
        //log.info("mso:{}",mso1);
        log.info("mso:{}",mso);
        mybatisStudyOne mso1=new mybatisStudyOne();
        mso1.setName("ddddd");
        mso1=msomapper.queryMstudyList(mso1);
        log.info("mso1:{}",mso1);
    }

    @Test
    public void queryMstudyCount() throws Exception {
        mybatisStudyOne mso=new mybatisStudyOne();
        Integer count=0;
        MybatisStudyOne msomapper = session.getMapper(MybatisStudyOne.class);
        count=msomapper.queryMstudyCount(mso);
        log.info(count.toString());
    }

    @Test
    public void insertmStudy() throws Exception {
        mybatisStudyOne mso = new mybatisStudyOne();
        mso.setName("树叶");
        mso.setAddress("眼前");
        MybatisStudyOne msomapper= session.getMapper(MybatisStudyOne.class);
        Integer i = msomapper.insertmStudy(mso);
        log.info("i={}",i);
        log.info("id={}",mso.getId());
    }

    @Test
    public void queryBatchId() throws Exception {

    }

    @Test
    public void queryBatchIds() throws Exception {
    }

    @Test
    public void insertBatchId() throws Exception {
    }

    @Test
    public void updateBatchId() throws Exception {
    }
    @Test
    public void queryOrder(){
        mybatisStudyOne mso=new mybatisStudyOne();
        //mso.setId(1);
        MybatisStudyOne msomapper = session.getMapper(MybatisStudyOne.class);
        List<mybatisStudyOne> mlist= msomapper.queryOrder(mso);
        //log.info("mso:{}",mso1);
        for (mybatisStudyOne m:mlist){
            log.info("mso:{}",m);
        }
    }
    @Test
    public void queryBuyGm(){
        mybatisStudyOne mso=new mybatisStudyOne();
        mso.setId("1003");
        MybatisStudyOne msomapper = session.getMapper(MybatisStudyOne.class);
        List<mybatisStudyOne> mlist= msomapper.queryBuyGm(mso);
        //log.info("mso:{}",mso1);
        for (mybatisStudyOne m:mlist){
            log.info("mso:{}",m);
        }
    }
    @Test
    public void testCache() throws Exception{
        SqlSession sqlsession1= new mybatisUtil().getsession(str);
        SqlSession sqlsession2= new mybatisUtil().getsession(str);
        //创建代理对象
        MybatisStudyOne msomapper = sqlsession1.getMapper(MybatisStudyOne.class);
        //下边查询使用一个SqlSession
        //第一次发起请求，查询id为1003的用户
        mybatisStudyOne mbso= (mybatisStudyOne) msomapper.findBuyById(Integer.valueOf(1003));
        System.out.println(mbso.getName());
        //不关闭SqlSession无法写进二级缓存区域中
        sqlsession1.close();
        //创建代理对象
        MybatisStudyOne msomapper1 = sqlsession1.getMapper(MybatisStudyOne.class);
        //第二次发起请求，查询id为1003的用户
        mybatisStudyOne mbso2= (mybatisStudyOne) msomapper.findBuyById(Integer.valueOf(1003));
        System.out.println(mbso2.getName());
        sqlsession2.close();
    }
}