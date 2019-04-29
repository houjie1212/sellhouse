package com.sellhourse.config.datasource;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

@Configuration
@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type",
    havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
public class DataSourceConfiguration {

  // private Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

  @Autowired
  private DruidDataSourceProperty druidDataSourceProperty;

  @Bean
  @Primary // 在同样的DataSource中，首先使用被标注的DataSource
  public DataSource dataSource() {
    DruidDataSource datasource = new DruidDataSource();

    datasource.setUrl(druidDataSourceProperty.getUrl());
    datasource.setUsername(druidDataSourceProperty.getUsername());
    datasource.setPassword(druidDataSourceProperty.getPassword());
    datasource.setDriverClassName(druidDataSourceProperty.getDriverClassName());

    datasource.setInitialSize(druidDataSourceProperty.getInitialSize());
    datasource.setMinIdle(druidDataSourceProperty.getMinIdle());
    datasource.setMaxActive(druidDataSourceProperty.getMaxActive());
    // 配置获取连接等待超时的时间
    datasource.setMaxWait(druidDataSourceProperty.getMaxWait());
    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    datasource.setTimeBetweenEvictionRunsMillis(
      druidDataSourceProperty.getTimeBetweenEvictionRunsMillis());
    // 配置一个连接在池中最小生存的时间，单位是毫秒
    datasource
        .setMinEvictableIdleTimeMillis(druidDataSourceProperty.getMinEvictableIdleTimeMillis());
    datasource.setValidationQuery(druidDataSourceProperty.getValidationQuery());
    datasource.setTestWhileIdle(druidDataSourceProperty.isTestWhileIdle());
    datasource.setTestOnBorrow(druidDataSourceProperty.isTestOnBorrow());
    datasource.setTestOnReturn(druidDataSourceProperty.isTestOnReturn());
    datasource.setPoolPreparedStatements(druidDataSourceProperty.isPoolPreparedStatements());
    datasource.setMaxPoolPreparedStatementPerConnectionSize(
      druidDataSourceProperty.getMaxPoolPreparedStatementPerConnectionSize());
    datasource.setUseGlobalDataSourceStat(druidDataSourceProperty.isUseGlobalDataSourceStat());

    List<Filter> filters = new ArrayList<>();
    filters.add(wallFilter);
    datasource.setProxyFilters(filters);

    datasource.setConnectionProperties(druidDataSourceProperty.getConnectionProperties());
    return datasource;
  }

  @Autowired
  WallFilter wallFilter;

  @Bean(name = "wallConfig")
  WallConfig wallFilterConfig() {
    WallConfig wc = new WallConfig();
    wc.setMultiStatementAllow(true);
    return wc;
  }

  @Bean(name = "wallFilter")
  @DependsOn("wallConfig")
  WallFilter wallFilter(WallConfig wallConfig) {
    WallFilter wfilter = new WallFilter();
    wfilter.setConfig(wallConfig);
    return wfilter;
  }

}
