package cc.nanoic.ucsp.server.entity.entity0;

import lombok.Data;

/**
 * @FileName authorityy
 * @Description
 * @Author fazhu
 * @date 2024-05-18
 **/
@Data
public class authority {
    private Integer user_id;//更改身份的用户
    private Integer authority_old;//要更改的身份码
    private Integer authority_new;//更改的身份码

}
