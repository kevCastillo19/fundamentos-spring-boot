package com.fundamentos.springboot.fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanPropertiesImplement;
import com.fundamentos.springboot.fundamentos.pojo.UsePojo;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UsePojo.class)
public class GeneralConfiguration {
	@Value("${value.name}")
	private String name;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Value("${value.random}")
	private String random;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${username}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public MyBeanProperties function() {
		return new MyBeanPropertiesImplement(name, apellido);
	}
	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(jdbcUrl);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}
}
