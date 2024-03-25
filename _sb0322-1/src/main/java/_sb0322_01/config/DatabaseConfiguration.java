package _sb0322_01.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

	@Autowired
	private ApplicationContext applicationContext;
//	@Bean 돌리는 공장
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
//	@PropertySource("classpath:/application.properties") 여기서 읽어오겠다는 말임
	public HikariConfig hikariConfig() {
		System.out.println("hikariConfig()");
		return new HikariConfig();
	}

	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		System.out.println("mybatisConfig()");
		return new org.apache.ibatis.session.Configuration();
	}

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("dataSource()");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
//		개발자 입장에서는 다른 것보다도 getResounces의 클래스패스를 봐야함 저 파일이 필요한거거든
//		저거 mapper 뒤에 ** 나오는 건 mapper 폴더 아래에 몇 개의 폴더를 더 생성해도 가능하다는 말임 모든 디렉토리라고 생각하면 됨
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		System.out.println("sqlSessionFactory()");
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		System.out.println("sqlSessionTemplate()");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
