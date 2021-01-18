package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		UsersDao usersDao = context.getBean(UsersDao.class);

		Users user1= new Users();
		user1.setFirstName("Rutu");
		user1.setLastName("Gaikwad");
		user1.setEmailId("rutu@gmail.com");
		user1.setMobileNumber("9087654321");
		user1.setPassword("123456");
		user1.setWalletMoney(10000);

		user1=usersDao.save(user1);

		Users user2= new Users();
		user2.setFirstName("Sunanda");
		user2.setLastName("Gaikwad");
		user2.setEmailId("sunanda@gmail.com");
		user2.setMobileNumber("9087667821");
		user2.setPassword("444456");
		user2.setWalletMoney(10000);

		user2=usersDao.save(user2);

		Users user3= new Users();
		user3.setFirstName("keku");
		user3.setLastName("Gaikwad");
		user3.setEmailId("keku@gmail.com");
		user3.setMobileNumber("9565469821");
		user3.setPassword("keku123");
		user3.setWalletMoney(10000);

		user3=usersDao.save(user3);

		Users user4= new Users();
		user4.setFirstName("Sujit");
		user4.setLastName("Gaikwad");
		user4.setEmailId("sujit@gmail.com");
		user4.setMobileNumber("9088888821");
		user4.setPassword("sujit567");
		user4.setWalletMoney(10000);

		user4=usersDao.save(user4);

		Users user5= new Users();
		user5.setFirstName("Chinna");
		user5.setLastName("Gaikwad");
		user5.setEmailId("chinna@gmail.com");
		user5.setMobileNumber("9088888871");
		user5.setPassword("chinnu456");
		user5.setWalletMoney(10000);

		user5=usersDao.save(user5);

		usersDao.findAll().forEach(System.out::println);

		Page<Users> page0 = usersDao.findAll(PageRequest.of(0, 2));
		page0.stream().forEach(user -> System.out.println(user));


		usersDao.findByFirstNameOrLastName("Rutu", "gaikwad").forEach(System.out::println);

		Users u=usersDao.findByEmailId("sunanda@gmail.com");
		System.out.println(u);


	}

}
