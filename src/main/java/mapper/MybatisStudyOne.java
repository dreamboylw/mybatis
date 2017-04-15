package mapper;

import entity.mybatisStudyOne;

import java.util.List;

/**
 * Created by admin on 2017/4/12.
 */
public interface MybatisStudyOne {
    //批量查询
    //public List<mybatisStudyOne> query
    public mybatisStudyOne queryMstudyList(mybatisStudyOne mso);
    public mybatisStudyOne findBuyById(Integer mso);
    public Integer queryMstudyCount(mybatisStudyOne mso);
    public Integer insertmStudy(mybatisStudyOne mso);
    public mybatisStudyOne queryBatchId(mybatisStudyOne mso);
    public List<mybatisStudyOne> queryBatchIds(List<mybatisStudyOne> list);
    public int insertBatchId(List<mybatisStudyOne> list);
    public int updateBatchId(List<mybatisStudyOne> list);
    public List<mybatisStudyOne>queryOrder(mybatisStudyOne mso);
    public List<mybatisStudyOne>queryBuyGm(mybatisStudyOne mso);
}
