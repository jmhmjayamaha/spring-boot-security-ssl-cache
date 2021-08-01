package lk.harshana.app.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		System.out.println(bcrypt.encode("harsha123"));
		System.out.println(bcrypt.encode("kawshi123"));
		System.out.println(bcrypt.encode("madu123"));
	}
}
