package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2017/4/7.
 */
@Data
public class gm_goods implements Serializable {
    private  int id;
    private  String goodsname;
    private  int tid;
    private  String price;
    private  int store;
    private  String status;
    private  String descr;
    private  int num;
    private  String company;
    private  String addtime;
    private  String picname;
    private  String picaddress;

}
