package cc.nanoic.ucsp.server.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-15
 * @FileName: Confignature
 **/

@Configuration
public class Confignature {


    public static String DATASOURCE_DRIVER_CLASS_NAME; //驱动

    public static String DATASOURCE_URL; //oracle url

    public static String DATASOURCE_USERNAME; // oracle 用户名

    public static String DATASOURCE_PASSWORD; // oracle 密码

    @Value(value = "${spring.datasource.driver-class-name}")
    public void setDatasourceDriveCalssName(String datasourceDriveClassName){
        DATASOURCE_DRIVER_CLASS_NAME = datasourceDriveClassName;
    }

    @Value("${spring.datasource.url}")
    public void setDatasourceUrl(String datasourceUrl) {
        DATASOURCE_URL = datasourceUrl;
    }

    @Value("${spring.datasource.username}")
    public void setDatasourceUsername(String datasourceUsername) {
        DATASOURCE_USERNAME = datasourceUsername;
    }

    @Value("${spring.datasource.password}")
    public void setDatasourcePassword(String datasourcePassword) {
        DATASOURCE_PASSWORD = datasourcePassword;
    }
}