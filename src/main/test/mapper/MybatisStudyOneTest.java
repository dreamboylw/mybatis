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
    @Before
    public void setUp() throws Exception {
        String str="mybatis.xml";
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
}