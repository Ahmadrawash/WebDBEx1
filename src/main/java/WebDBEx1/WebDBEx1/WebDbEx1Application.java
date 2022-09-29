package WebDBEx1.WebDBEx1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = "WebDBEx1.WebDBEx1",
//		exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication(scanBasePackages = "WebDBEx1.WebDBEx1")
@EntityScan("WebDBEx1.WebDBEx1.model")
public class WebDbEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebDbEx1Application.class, args);
	}

}
