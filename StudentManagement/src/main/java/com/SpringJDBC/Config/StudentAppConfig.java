package com.SpringJDBC.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.SpringJDBC")
public class StudentAppConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Project_Test?useSSL=false");
		dataSource.setUsername("postgres");
		dataSource.setPassword("Smart@123");
		
		return dataSource;
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/URLToReachResourcesFolder/**") 
		.addResourceLocations("/resources/");
		
		registry
		.addResourceHandler("/URLToReachImagesFolder/**") 
		.addResourceLocations("/resources/images/");
	}

	
	
	

}
