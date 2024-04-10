package com.zfcgdbinterface.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author zht
 **/
@Configuration
public class DruidConfig {

    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        //基本
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //TODO 47.100.238.217
        druidDataSource.setUrl("jdbc:mysql://120.79.197.110:3306/credit?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&characterEncoding=utf-8");
        //TODO
        druidDataSource.setUsername("yueru");
        //TODO gdgmb105
        druidDataSource.setPassword("YueRu8080");

        //配置
        druidDataSource.setInitialSize(5);
        //最小空闲数
        druidDataSource.setMinIdle(2);
        druidDataSource.setMaxActive(50);
        //每隔1分钟查看需要关闭的空闲连接
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        //超时等待1分钟
        druidDataSource.setMaxWait(60000);
        //
        druidDataSource.setQueryTimeout(2);

        return druidDataSource;

    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(druidDataSource());
        return dataSourceTransactionManager;
    }

}
