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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.workdaka.mapper.local"}, sqlSessionFactoryRef = "localSqlSessionFactory")
public class LocalDBConfig {
    @Primary
    @Bean(name = "localDataSource")
    @ConfigurationProperties(prefix="spring.datasource.local")
    public DataSource localDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * SqlSessionFactoryBean需要改成MybatisSqlSessionFactoryBean，否则baseMapper自带的方法不能访问，但能访问*Mapper.xml中定义的方法或者接口注解的自定义sql的方法
     */
    @Primary
    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("localDataSource") DataSource dataSource) throws Exception {
        /*SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mapper/local/*.xml"));
        return sessionFactoryBean.getObject();*/
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:static/mapper/local/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean("localSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

