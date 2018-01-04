package com.minson.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by pocan on 2018/1/3.
 * JPA配置类
 * 存放项目配置类。类似SSM架构下，spring需要配置Java POJO类包路径以及DAO层接口路径，
 * 以自动扫描相关注解，这里同样需要配置这两项，不同的是Spring采取的是xml配置方式，这里用Java代码+注解方式配置
 * @Order 组件的加载顺序
 * @Configuration 定义一个配置类
 * @EnableTransactionManagement 与<tx:annotation-driven/>相同，负责注册注解驱动的事务管理Spring组件
 * @EnableJpaRepositories 启用扫描注解的JPA仓库
 * @EntityScan 启用扫描注解的实体类
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.minson.repository")
@EntityScan(basePackages = "com.minson.entity")
public class JpaConfiguration {
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}