package com.capgemini.testmanagementsystem.app;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.capgemini.testmanagementsystem.app.entity.QuestionBank;
import com.capgemini.testmanagementsystem.app.entity.TestBank;
import com.capgemini.testmanagementsystem.app.entity.User;
import com.capgemini.testmanagementsystem.app.entity.WorkSpaceData;

@Transactional
@SpringBootApplication
public class OnlineTestManagementSystemApplication implements CommandLineRunner{
	@PersistenceContext
	EntityManager myManager;
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		QuestionBank question1= new QuestionBank("The sum of all two digit numbers divisible by 5 is","945,678,439,568",new BigDecimal(40),1,"Aptitude","Easy");
		myManager.persist(question1);
		
		QuestionBank question2= new QuestionBank("Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?","25200,52000,120,24400",new BigDecimal(4),1,"Aptitude","Easy");
		myManager.persist(question2);
		
		QuestionBank question3= new QuestionBank("Danish","1,2,3,4",new BigDecimal(40),1,"Aptitude","Easy");
		myManager.persist(question3);
		
		Set<QuestionBank> questions = new HashSet<QuestionBank>();
		questions.add(question1);
		questions.add(question2);
		
		Set<QuestionBank> question11 = new HashSet<QuestionBank>();
		question11.add(question3);
		
		TestBank generalAptitude = new TestBank("Suraj" , LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), questions);
		myManager.persist(generalAptitude);
		
		TestBank generalAptitude1 = new TestBank("Danish" , LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), question11);
		myManager.persist(generalAptitude1);
		
		User suraj = new User("Suraj","12345",true);
		myManager.persist(suraj);
		
	    WorkSpaceData data = new WorkSpaceData(Long.parseLong("1"),BigInteger.valueOf(1),
	    		Integer.valueOf(0));
		myManager.persist(data);
	}
}
