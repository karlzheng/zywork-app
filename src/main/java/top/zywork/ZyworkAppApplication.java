package top.zywork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@ServletComponentScan
@MapperScan("top.zywork.dao")
@EnableCaching
public class ZyworkAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZyworkAppApplication.class, args);
	}
}
