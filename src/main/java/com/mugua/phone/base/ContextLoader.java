package com.mugua.phone.base;

import com.youguu.core.dao.DataSourceLoader;
import com.youguu.core.dao.multi.MultiDataSourceTransactionManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration("phoneToolContextLoader")
@ComponentScan({"com.mugua.phone.*"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextLoader extends DataSourceLoader {

    public DataSource getDataSource(String selector) {
        return load(selector, selector);
    }

    @Bean
    public SqlSessionFactory phoneToolSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getDataSource("/phoneTool"));
        DefaultResourceLoader dc = new DefaultResourceLoader();
        bean.setConfigLocation(dc.getResource("classpath:mybatis/phone-tool-mapper-config.xml"));
        return bean.getObject();
    }

    @Bean(name = "phoneToolTX")
    public DataSourceTransactionManager superTransactionManager() {
        DataSourceTransactionManager transactionManager = new MultiDataSourceTransactionManager();
        transactionManager.setDataSource(getDataSource("phoneTool"));
        return transactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
