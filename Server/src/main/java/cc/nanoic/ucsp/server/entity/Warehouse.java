package cc.nanoic.ucsp.server.entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

@Data
public class Warehouse {
    private Integer snapped_id;  //抢购id
    private String goods_name;  //物品名
    private Integer goods_inventory;  //库存量
    private Integer goods_pre_sale_volume;  //预售量
    private long startTime;
    private long eddTime;
    private DateTime start_date;  //开始时间
    private DateTime end_date;  //结束时间
}
