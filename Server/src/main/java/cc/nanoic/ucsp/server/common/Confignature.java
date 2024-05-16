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

    @Value(value = "${spring.datasource.driver-class-name}")
    public String DATASOURCE_DRIVER_CLASS_NAME; //SQL驱动

    public static String DATASOURCE_URL; //SQL url

    public static String DATASOURCE_USERNAME; // SQL 用户名

    public static String DATASOURCE_PASSWORD; // SQL 密码

    @Value("${spring.datasource.url}")
    public void setDatasourceDruidUrl(String datasourceDruidUrl) {
        DATASOURCE_URL = datasourceDruidUrl;
    }

    @Value("${spring.datasource.username}")
    public void setDatasourceDruidUsername(String datasourceDruidUsername) {
        DATASOURCE_USERNAME = datasourceDruidUsername;
    }

    @Value("${spring.datasource.password}")
    public void setDatasourceDruidPassword(String datasourceDruidPassword) {
        DATASOURCE_PASSWORD = datasourceDruidPassword;
    }
}
