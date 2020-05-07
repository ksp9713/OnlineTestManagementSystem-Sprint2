package com.capgemini.onlinetestmanagementsystem.app;

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

import com.capgemini.onlinetestmanagementsystem.app.entity.QuestionBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;

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
		
		QuestionBank question1= new QuestionBank("The sum of all two digit numbers divisible by 5 is","945","678","439","568","945",4d);
		
		QuestionBank question2= new QuestionBank("Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?","25200","52000","120","24400","25200",4d);
		
		QuestionBank question3= new QuestionBank("In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was :","2500","2700","2900","3100","2700",4d);
		
		QuestionBank question4= new QuestionBank("A problem is given to three students whose chances of solving it are 1/2, 1/3 and 1/4 respectively. What is the probability that the problem will be solved?","1/4","1/2","3/4","7/12","3/4",4d);
		
		QuestionBank question5= new QuestionBank("What least number must be added to 1056, so that the sum is completely divisible by 23 ?","2","3","18","21","2",4d);
		
		QuestionBank question6= new QuestionBank("If the number 517*324 is completely divisible by 3, then the smallest whole number in the place of * will be:","0","1","2","4","2",4d);
		
		QuestionBank question7= new QuestionBank("Which one of the following numbers is exactly divisible by 11?","235641","245642","315624","415624","415624",4d);
		
		QuestionBank question8= new QuestionBank("On dividing a number by 357, we get 39 as remainder. On dividing the same number 17, what will be the remainder ?","0","3","5","11","5",4d);
		
		QuestionBank question9= new QuestionBank("On multiplying a number by 7, the product is a number each of whose digits is 3. The smallest such number is:","47619","47719","48619","47649","47619",4d);
		
		QuestionBank question10= new QuestionBank("Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?","9","10","12","20","10",4d);
		
		QuestionBank question11= new QuestionBank("The angle of elevation of a ladder leaning against a wall is 60° and the foot of the ladder is 4.6 m away from the wall. The length of the ladder is:","2.3 m","4.6 m","7.8 m","9.2 m","9.2 m",4d);
		
		QuestionBank question12= new QuestionBank("The angle of elevation of the sun, when the length of the shadow of a tree 3 times the height of the tree, is:","30 degree","45 degree","60 degree","90 degree","30 degree",4d);
		
		QuestionBank question13= new QuestionBank("A can do a piece of work in 4 hours; B and C together can do it in 3 hours, while A and C together can do it in 2 hours. How long will B alone take to do it?","8 hours","10 hours","12 hours","24 hours","12 hours",4d);
		
		QuestionBank question14= new QuestionBank("A can do a certain work in the same time in which B and C together can do it. If A and B together could do it in 10 days and C alone in 50 days, then B alone could do it in:","15 days","20 days","25 days","30 days","25 days",4d);
		
		QuestionBank question15= new QuestionBank("A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is:","Rs. 650","Rs. 690","Rs. 698","Rs. 700","Rs. 698",4d);
		
		QuestionBank question16= new QuestionBank("How much time will it take for an amount of Rs. 450 to yield Rs. 81 as interest at 4.5% per annum of simple interest?","3.5 years","4 years","4.5 years","5 years","4 years",4d);
		
		QuestionBank question17= new QuestionBank("The cost price of 20 articles is the same as the selling price of x articles. If the profit is 25%, then the value of x is:","15","16","18","25","16",4d);
		
		QuestionBank question18= new QuestionBank("A vendor bought toffees at 6 for a rupee. How many for a rupee must he sell to gain 20%?","3","4","5","6","5",4d);
		
		QuestionBank question19= new QuestionBank("A man is 24 years older than his son. In two years, his age will be twice the age of his son. The present age of his son is:","14 years","18 years","20 years","22 years","22 years",4d);
		
		QuestionBank question20= new QuestionBank("The sum of the present ages of a father and his son is 60 years. Six years ago, father's age was five times the age of the son. After 6 years, son's age will be:","12 years","14 years","18 years","20 years","20 years",4d);
		
		QuestionBank question21= new QuestionBank("Today is Monday. After 61 days, it will be:","Wednesday","Saturday","Tuesday","Thrusday","Saturday",4d);
		
		QuestionBank question22= new QuestionBank("The last day of a century cannot be","Monday","Wednesday","Tuesday","Friday","Tuesday",4d);
		
		QuestionBank question23= new QuestionBank("The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?","0","1","10","19","19",4d);
		
		QuestionBank question24= new QuestionBank("The average weight of A, B and C is 45 kg. If the average weight of A and B be 40 kg and that of B and C be 43 kg, then the weight of B is:","17 kg","20 kg","26 kg","31 kg","31 kg",4d);
		
		QuestionBank question25= new QuestionBank("What was the day on 15th august 1947 ?","Friday","Saturday","Sunday","Thrusday","Friday",4d);
		
		
		myManager.persist(question1);
		myManager.persist(question2);
		myManager.persist(question3);
		myManager.persist(question4);
		myManager.persist(question5);
		myManager.persist(question6);
		myManager.persist(question7);
		myManager.persist(question8);
		myManager.persist(question9);
		myManager.persist(question10);
		myManager.persist(question11);
		myManager.persist(question12);
		myManager.persist(question13);
		myManager.persist(question14);
		myManager.persist(question15);
		myManager.persist(question16);
		myManager.persist(question17);
		myManager.persist(question18);
		myManager.persist(question19);
		myManager.persist(question20);
		myManager.persist(question21);
		myManager.persist(question22);
		myManager.persist(question23);
		myManager.persist(question24);
		myManager.persist(question25);
	
		
		Set<QuestionBank> questions = new HashSet<QuestionBank>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		questions.add(question4);
		questions.add(question5);
		
		
		Set<QuestionBank> questions1 = new HashSet<QuestionBank>();
		questions1.add(question6);
		questions1.add(question7);
		questions1.add(question8);
		questions1.add(question9);
		questions1.add(question10);
		
		
		TestBank test1 = new TestBank("Test 1" , LocalDateTime.of(2020,5,20,15,20,00), LocalDateTime.of(2020,5,20,15,20,00).plusMinutes(40), questions);
		myManager.persist(test1);
		
		TestBank test2 = new TestBank("Test 2" , LocalDateTime.of(2020,5,21,15,20,00), LocalDateTime.of(2020,5,21,15,20,00).plusMinutes(40), questions1);
		myManager.persist(test2);
		
		
		User suraj = new User("Suraj","12345",false);
		myManager.persist(suraj);
		
		User sachin = new User("Sachin","Sachin@123", true);
		myManager.persist(sachin);
		
		User user1 = new User("User1","User@123",false);
		myManager.persist(user1);;
		
	    WorkSpaceData data = new WorkSpaceData(Long.parseLong("1"),BigInteger.valueOf(1), 0);
		myManager.persist(data);
	}
}
