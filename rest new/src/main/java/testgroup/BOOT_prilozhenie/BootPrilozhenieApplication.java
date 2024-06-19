package testgroup.BOOT_prilozhenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BootPrilozhenieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPrilozhenieApplication.class, args);
	}

}
