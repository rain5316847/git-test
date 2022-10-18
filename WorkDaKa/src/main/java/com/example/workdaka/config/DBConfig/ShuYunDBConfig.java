package com.example.workdaka.config.DBConfig;

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

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.workdaka.mapper.shuyun"}, sqlSessionFactoryRef = "shuyunSqlSessionFactory")
public class ShuYunDBConfig {

    @Bean(name = "shuyunDataSource")
    @ConfigurationProperties(prefix="spring.datasource.shuyun")
    public DataSource shuyunDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * SqlSessionFactoryBean需要改成MybatisSqlSessionFactoryBean，否则baseMapper自带的方法不能访问，但能访问*Mapper.xml中定义的方法或者接口注解的自定义sql的方法
     */
    @Bean(name = "shuyunSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("shuyunDataSource") DataSource dataSource) throws Exception {
        /*SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/shuyun/*.xml"));
        return sessionFactoryBean.getObject();*/
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean("shuyunSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
