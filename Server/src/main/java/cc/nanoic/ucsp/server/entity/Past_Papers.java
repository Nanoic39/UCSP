package cc.nanoic.ucsp.server.entity;

import lombok.Data;

@Data
public class Past_Papers {
    private int id;
    private String papers_name;
    private String content;
    private int status;
    private Integer type;
}