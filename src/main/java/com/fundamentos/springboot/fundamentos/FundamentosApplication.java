package com.fundamentos.springboot.fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UsePojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.services.UserService;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{
	
	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UsePojo usePojo;
	private UserRepository userRepository;
	private UserService userService;
	
	public FundamentosApplication(@Qualifier("componentImplement") ComponentDependency componentDependency,
									MyBean myBean, MyBeanWithDependency myBeanWithDependency,
									MyBeanProperties myBeanProperties,
									UsePojo usePojo, UserRepository userRepository,
									UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.usePojo = usePojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsersDataBase();
		getInformacionJpqlFromUser();
		saveWithErrorTransactional();
	}
	
	private void saveWithErrorTransactional() {
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional1@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
		
		List<User> users = Arrays.asList(test1,test2,test3,test4);
		
		try {
			userService.saveTransactional(users);
		} catch (Exception e) {
			LOGGER.error("Esta es una excepcion: " + e);
		}
		
		userService.getAllUsers().stream()
			.forEach(user -> LOGGER.info("Usuario transactional" + user));
	}
	
	private void getInformacionJpqlFromUser() {
		/*
		 * LOGGER.info("Usuario findByUserEmail " +
		 * userRepository.findByUserEmail("user4@gmail.com") .orElseThrow(()-> new
		 * RuntimeException("No se encontro ningun usuario")));
		 * 
		 * userRepository.findAndSort("user", Sort.by("id").descending()) .stream()
		 * .forEach(user -> LOGGER.info("usuario findAndSorte" + user));
		 * 
		 * userRepository.findByName("user1") .stream() .forEach(user ->
		 * LOGGER.info("usuario findByName" + user));
		 * 
		 * userRepository.findByNameAndEmail("user9", "user9@gmail.com") .stream()
		 * .forEach(user -> LOGGER.info("usuario findByNameAndEmail" + user));
		 * 
		 * userRepository.findByNameOrEmail(null, "user9@gmail.com") .stream()
		 * .forEach(user -> LOGGER.info("usuario findByNameOrEmail" + user));
		 * 
		 * userRepository.findByNameLike("user1%") .stream() .forEach(user ->
		 * LOGGER.info("usuario findByNameLike" + user));
		 * 
		 * userRepository.findByBirthDateBetween(LocalDate.of(2021, 3, 1), LocalDate.of(2021, 6, 1)) .stream() .forEach(user ->
		 * LOGGER.info("usuario findByNameLike" + user));
		 */
		
		LOGGER.info(userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 5, 9), "user1@gmail.com") 
			.orElseThrow(()-> 
				new RuntimeException("No se encontro el usuario")));
		
	}
	
	private void saveUsersDataBase(){
		User user1 = new User("user1", "user1@gmail.com", LocalDate.of(2021, 5, 9));
		User user2 = new User("user2", "user2@gmail.com", LocalDate.of(2021, 5, 9));
		User user3 = new User("user3", "user3@gmail.com", LocalDate.of(2021, 6, 9));
		User user4 = new User("user4", "user4@gmail.com", LocalDate.of(2021, 7, 9));
		User user5 = new User("user5", "user5@gmail.com", LocalDate.of(2021, 11, 9));
		User user6 = new User("user6", "user6@gmail.com", LocalDate.of(2021, 11, 9));
		User user7 = new User("user7", "user7@gmail.com", LocalDate.of(2021, 8, 9));
		User user8 = new User("user8", "user8@gmail.com", LocalDate.of(2021, 1, 9));
		User user9 = new User("user9", "user9@gmail.com", LocalDate.of(2021, 11, 9));
		User user10 = new User("user10", "user10@gmail.com", LocalDate.of(2021, 11, 9));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9, user10);
		list.stream().forEach(userRepository::save);
	}
	
	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanProperties.function());
		System.out.println(usePojo.getEmail() + " " + usePojo.getPassword());
		try {
			int value = 10 / 1;
			LOGGER.info("No hay error");
		} catch (Exception e) {			
			LOGGER.error("Esto es un error al dividr por cero " + e.getMessage());
		}
	}

}
