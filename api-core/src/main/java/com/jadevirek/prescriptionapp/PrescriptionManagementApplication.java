package src.main.java.com.jadevirek.prescriptionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PrescriptionManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionManagementApplication.class, args);
	}

}
