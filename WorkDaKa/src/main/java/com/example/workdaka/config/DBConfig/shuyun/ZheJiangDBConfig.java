package com.example.workdaka.config.DBConfig.shuyun;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.workdaka.mapper.zhejiang"}, sqlSessionFactoryRef = "zhejiangSqlSessionFactory")
public class ZheJiangDBConfig {

    @Bean(name = "zhejiangDataSource")
    @ConfigurationProperties(prefix="spring.datasource.zhejiang")
    public DataSource zhejiangDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * SqlSessionFactoryBean需要改成MybatisSqlSessionFactoryBean，否则baseMapper自带的方法不能访问，但能访问*Mapper.xml中定义的方法或者接口注解的自定义sql的方法
     */
    @Bean(name = "zhejiangSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("zhejiangDataSource") DataSource dataSource) throws Exception {
        /*SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/zhejiang/*.xml"));
        return sessionFactoryBean.getObject();*/
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:static/mapper/zhejiang/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean("zhejiangSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
