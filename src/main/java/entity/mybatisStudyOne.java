package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/4/12.
 */
@Data
public class mybatisStudyOne{
    private String id;
    private String name;
    private String address;
    private List<buylatest1> buylatest1;
    private gm_goods goods;
}
