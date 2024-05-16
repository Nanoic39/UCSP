package cc.nanoic.ucsp.server.common;

import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-09
 * @FileName: CommonDao
 **/

public class CommonDao extends SqlSessionDaoSupport {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}