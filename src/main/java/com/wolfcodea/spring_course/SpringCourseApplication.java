package com.wolfcodea.spring_course;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
// import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

@SpringBootApplication
public class SpringCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);

		// Map<String, PasswordEncoder> encoders = new HashMap<>();

		// Pbkdf2PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder("", 8,
		// 185000,
		// SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
		// encoders.put("pbkdf2", pbkdf2Encoder);
		// DelegatingPasswordEncoder passwordEncoder = new
		// DelegatingPasswordEncoder("pbkdf2", encoders);
		// passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
		// String result = passwordEncoder.encode("admin1234");

		// System.out.println("My hash is " + result);
	}

}
