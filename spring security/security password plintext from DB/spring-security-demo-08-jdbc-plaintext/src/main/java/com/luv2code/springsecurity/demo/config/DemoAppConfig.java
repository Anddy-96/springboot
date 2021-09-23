package com.luv2code.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages =  "com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
		
	
	//set up the variables to hold the properties
	@Autowired
	private Environment env;
	
	//set up a logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//define a bean for view resolver
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
	}
	
	//define bean for our security datasource
	@Bean
	public DataSource securityDataSource()
	{
		//create  connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		//log the connection properties
		logger.info("===>> JDBC URL :"+ env.getProperty("jdbc.url"));
		logger.info("===>> JDBC user :"+ env.getProperty("jdbc.user"));
		
		//set the database connection properties
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool properties
		
		securityDataSource.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));
		
		 return securityDataSource;
	}
	
	//need a helper method to convert string to int
	private int getInt(String prop)
	{
		String propname = env.getProperty(prop);
		int intname = Integer.parseInt(propname);
		
		return intname;
		
		
		
	}
	
}
