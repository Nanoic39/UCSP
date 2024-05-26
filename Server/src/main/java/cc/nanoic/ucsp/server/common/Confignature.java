/*
 * @Author: Nanoic
 * @LastEditors: Nanoic 2026256242@qq.com
 * @Date: 2024-05-15 15:57:49
 * @LastEditTime: 2024-05-18 17:01:47
 * @FilePath:
 * @Describe: 
 */
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

    //数据库相关
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


    //密钥相关
    public static String SMS_Access_ID;
    public static String SMS_Access_Secret;

    @Value("${keys.SMSAccessID}")
    public void setSMSAccessID(String sms_access_id) {
        SMS_Access_ID = sms_access_id;
    }

    @Value("${keys.SMSAccessSecret}")
    public void setSMSAccessSecret(String sms_access_secret) {
       SMS_Access_Secret = sms_access_secret;
    }

    //上传相关
    public static String  FILE_UPLOAD_PATH;
    public static String  FILE_UPLOAD_PATH_IMAGE;
    public static String  FILE_UPLOAD_PATH_FILE;
    public static String  FILE_UPLOAD_PATH_HEAD_IMAGE;

    @Value("${costume.upload.path}")
    public void setFileUploadPath(String path) {
        FILE_UPLOAD_PATH = path;
    }

    @Value("${costume.upload.image}")
    public void setFileUploadPathImage(String path) {
        FILE_UPLOAD_PATH_IMAGE = FILE_UPLOAD_PATH + path;
    }

    @Value("${costume.upload.headImage}")
    public void setFileUploadPathHeadImage(String path) {
        FILE_UPLOAD_PATH_HEAD_IMAGE = FILE_UPLOAD_PATH + path;
    }
    @Value("${costume.upload.file}")
    public void setFileUploadPathFile(String path) {
        FILE_UPLOAD_PATH_FILE = FILE_UPLOAD_PATH + path;
    }

}
