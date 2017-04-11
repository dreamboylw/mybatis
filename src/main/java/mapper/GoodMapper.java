package mapper;

import entity.gm_goods;

import java.util.List;

/**
 * Created by admin on 2017/4/8.
 */
public interface GoodMapper {
    public gm_goods QueryGoodsById(Integer id);
    //public gm_goods QueryGoodsByGoodsId(gm_goods goods);
    //public List<gm_goods> QueryGoodsLimit(String like);
    //public List<gm_goods> QueryGoodsLimit(Integer page);
//    public Integer InsertGoods(gm_goods goods);
//    public Integer UpdateGoodsAll(gm_goods goods);
//    public Integer UpdateGoodsTrim(gm_goods goods);
//    public Integer UpdateGoodsSet(gm_goods goods);
//    public Integer DeleteGoods(gm_goods goods);
}
