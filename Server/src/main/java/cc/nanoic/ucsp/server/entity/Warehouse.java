package cc.nanoic.ucsp.server.entity;

import lombok.Data;

@Data
public class Warehouse {
    private String goods_name;
    private int goods_inventory;
    private int goods_pre_sale_volume;
}
