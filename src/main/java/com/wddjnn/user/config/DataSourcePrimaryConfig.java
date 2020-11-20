package com.wddjnn.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 默认数据源配置，
 */
@Configuration
@MapperScan(basePackages = "com.wddjnn.user.dao")
public class DataSourcePrimaryConfig {
    public static final String KEY = "transactionManager";

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name="dataSource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    /**
     * druidServlet注册
     */
    @Bean
    public ServletRegistrationBean druidServletRegistration() {
        ServletRegistrationBean srb = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加IP白名单
        srb.addInitParameter("allow", "172.17.195.98");
        // 添加控制台管理用户
        srb.addInitParameter("loginUsername", "MarketingCenter");
        srb.addInitParameter("loginPassword", "MC1234!@#$");
        // 是否能够重置数据
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    /**
     * druid监控 配置URI拦截策略
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter(
                "exclusions", "/static/*,*?*,*.js,*.gif,*.jpg,*.png,*.css,*.txt,*.ico,/druid,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * druid数据库连接池监控
     */
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns("com.wddjnn.user.dao.*","com.wddjnn.user.service.*");
        return pointcut;
    }
    @Bean
    public DefaultPointcutAdvisor druidStatAdvisor(DruidStatInterceptor druidStatInterceptor, JdkRegexpMethodPointcut druidStatPointcut) {
        DefaultPointcutAdvisor defaultPointAdvisor = new DefaultPointcutAdvisor();
        defaultPointAdvisor.setPointcut(druidStatPointcut);
        defaultPointAdvisor.setAdvice(druidStatInterceptor);
        return defaultPointAdvisor;
    }

}
