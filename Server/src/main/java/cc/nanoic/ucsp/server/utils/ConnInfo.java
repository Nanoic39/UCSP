package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.common.AuthAccess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 描述：获取数据库相关信息
 * @author 猿医生
 * @date 2018年10月31日
 *
 */
@RestController
public class ConnInfo {
    @AuthAccess
    @PostMapping("/bate")
    public static void main(String[] args){
        String sql="select * from ucsp ";
        // 用于调用存储过程：CallableStatement cs = null;
        PreparedStatement cs = null;
        ResultSetMetaData data = null;
        ResultSet rs = null;
        try {
            // 用于调用存储过程：cs = JDBCUtils.getConnection("url","username","password").prepareCall(sql);
            // 用于调用存储过程：cs.execute();
            System.out.println("000");
        cs = JDBCUtils.getConnection("jdbc:mysql://localhost:3306/ucsp","root","123456").prepareStatement(sql);
        rs = cs.executeQuery(sql);
        data = rs.getMetaData();
            System.out.println("11");
        while(rs.next()){
          for(int i = 1 ; i <= data.getColumnCount() ; i++){
              System.out.println("22");
            //获得所有列的数目及实际列数
            int columnCount = data.getColumnCount();
            //获得指定列的列名
            String columnName = data.getColumnName(i);
            //获得指定列的列值
            String columnValue = rs.getString(i);
            //获得指定列的数据类型
            int columnType = data.getColumnType(i);
            //获得指定列的数据类型名
            String columnTypeName = data.getColumnTypeName(i);
            //所在的Catalog名字
            String catalogName = data.getCatalogName(i);
            //对应数据类型的类
            String columnClassName = data.getColumnClassName(i);
            //在数据库中类型的最大字符个数
            int columnDisplaySize = data.getColumnDisplaySize(i);
            //默认的列的标题
            String columnLabel = data.getColumnLabel(i);
            //获得列的模式
            String schemaName = data.getSchemaName(i);
            //某列类型的精确度(类型的长度)
            int precision = data.getPrecision(i);
            //小数点后的位数
            int scale = data.getScale(i);
            //获取某列对应的表名
            String tableName = data.getTableName(i);
            // 是否自动递增
            boolean isAutoInctement = data.isAutoIncrement(i);
            //在数据库中是否为货币型
            boolean isCurrency = data.isCurrency(i);
            //是否为空
            int isNullable = data.isNullable(i);
            //是否为只读
            boolean isReadOnly = data.isReadOnly(i);
            //能否出现在where中
            boolean isSearchable = data.isSearchable(i);
            System.out.println(columnCount);
            System.out.println("获得列"+i+"的字段名称:"+columnName);
            System.out.println("获得列"+i+"的字段值:"+columnValue);
            System.out.println("获得列"+i+"的类型,返回SqlType中的编号:"+columnType);
            System.out.println("获得列"+i+"的数据类型名:"+columnTypeName);
            System.out.println("获得列"+i+"所在的Catalog名字:"+catalogName);
              System.out.println("获得列"+i+"对应数据类型的类:"+columnClassName);
              System.out.println("获得列"+i+"在数据库中类型的最大字符个数:"+columnDisplaySize);
              System.out.println("获得列"+i+"的默认的列的标题:"+columnLabel);
              System.out.println("获得列"+i+"的模式:"+schemaName);
              System.out.println("获得列"+i+"类型的精确度(类型的长度):"+precision);
              System.out.println("获得列"+i+"小数点后的位数:"+scale);
              System.out.println("获得列"+i+"对应的表名:" + tableName);
              System.out.println("获得列"+i+"是否自动递增:"+isAutoInctement);
              System.out.println("获得列"+i+"在数据库中是否为货币型:"+isCurrency);
              System.out.println("获得列"+i+"是否为空:"+isNullable);
              System.out.println("获得列"+i+"是否为只读:"+isReadOnly);
              System.out.println("获得列"+i+"能否出现在where中:"+isSearchable);          }
         }
        } catch (SQLException e) {
          System.out.println("数据库连接失败");
        }
      }
}