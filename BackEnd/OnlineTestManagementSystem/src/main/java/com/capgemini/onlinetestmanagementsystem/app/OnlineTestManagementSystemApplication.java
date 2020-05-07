package com.capgemini.onlinetestmanagementsystem.app;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
		
		QuestionBank question1= new QuestionBank("The sum of all two digit numbers divisible by 5 is","945","678","439","568",4d,"945","");
		
		QuestionBank question2= new QuestionBank("Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?","25200","52000","120","24400",4d,"25200","");
		
		QuestionBank question3= new QuestionBank("In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was :","2500","2700","2900","3100",4d,"2700","");
		
		QuestionBank question4= new QuestionBank("A problem is given to three students whose chances of solving it are 1/2, 1/3 and 1/4 respectively. What is the probability that the problem will be solved?","1/4","1/2","3/4","7/12",4d,"3/4","");
		
		QuestionBank question5= new QuestionBank("What least number must be added to 1056, so that the sum is completely divisible by 23 ?","2","3","18","21",4d,"2","");
		
		QuestionBank question6= new QuestionBank("If the number 517*324 is completely divisible by 3, then the smallest whole number in the place of * will be:","0","1","2","4",4d,"2","");
		
		QuestionBank question7= new QuestionBank("Which one of the following numbers is exactly divisible by 11?","235641","245642","315624","415624",4d,"415624","");
		
		QuestionBank question8= new QuestionBank("On dividing a number by 357, we get 39 as remainder. On dividing the same number 17, what will be the remainder ?","0","3","5","11",4d,"5","");
		
		QuestionBank question9= new QuestionBank("On multiplying a number by 7, the product is a number each of whose digits is 3. The smallest such number is:","47619","47719","48619","47649",4d,"47619","");
		
		QuestionBank question10= new QuestionBank("Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45 kmph. For how many minutes does the bus stop per hour?","9","10","12","20",4d,"10","");
		
		QuestionBank question11= new QuestionBank("The angle of elevation of a ladder leaning against a wall is 60° and the foot of the ladder is 4.6 m away from the wall. The length of the ladder is:","2.3 m","4.6 m","7.8 m","9.2 m",4d,"9.2 m","");
		
		QuestionBank question12= new QuestionBank("The angle of elevation of the sun, when the length of the shadow of a tree 3 times the height of the tree, is:","30 degree","45 degree","60 degree","90 degree",4d,"30 degree","");
		
		QuestionBank question13= new QuestionBank("A can do a piece of work in 4 hours; B and C together can do it in 3 hours, while A and C together can do it in 2 hours. How long will B alone take to do it?","8 hours","10 hours","12 hours","24 hours",4d,"12 hours","");
		
		QuestionBank question14= new QuestionBank("A can do a certain work in the same time in which B and C together can do it. If A and B together could do it in 10 days and C alone in 50 days, then B alone could do it in:","15 days","20 days","25 days","30 days",4d,"25 days","");
		
		QuestionBank question15= new QuestionBank("A sum of money at simple interest amounts to Rs. 815 in 3 years and to Rs. 854 in 4 years. The sum is:","Rs. 650","Rs. 690","Rs. 698","Rs. 700",4d,"Rs. 698","");
		
		QuestionBank question16= new QuestionBank("How much time will it take for an amount of Rs. 450 to yield Rs. 81 as interest at 4.5% per annum of simple interest?","3.5 years","4 years","4.5 years","5 years",4d,"4 years","");
		
		QuestionBank question17= new QuestionBank("The cost price of 20 articles is the same as the selling price of x articles. If the profit is 25%, then the value of x is:","15","16","18","25",4d,"16","");
		
		QuestionBank question18= new QuestionBank("A vendor bought toffees at 6 for a rupee. How many for a rupee must he sell to gain 20%?","3","4","5","6",4d,"5","");
		
		QuestionBank question19= new QuestionBank("A man is 24 years older than his son. In two years, his age will be twice the age of his son. The present age of his son is:","14 years","18 years","20 years","22 years",4d,"22 years","");
		
		QuestionBank question20= new QuestionBank("The sum of the present ages of a father and his son is 60 years. Six years ago, father's age was five times the age of the son. After 6 years, son's age will be:","12 years","14 years","18 years","20 years",4d,"20 years","");
		
		QuestionBank question21= new QuestionBank("Today is Monday. After 61 days, it will be:","Wednesday","Saturday","Tuesday","Thrusday",4d,"Saturday","");
		
		QuestionBank question22= new QuestionBank("The last day of a century cannot be","Monday","Wednesday","Tuesday","Friday",4d,"Tuesday","");
		
		QuestionBank question23= new QuestionBank("The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?","0","1","10","19",4d,"19","");
		
		QuestionBank question24= new QuestionBank("The average weight of A, B and C is 45 kg. If the average weight of A and B be 40 kg and that of B and C be 43 kg, then the weight of B is:","17 kg","20 kg","26 kg","31 kg",4d,"31 kg","");
		
		QuestionBank question25= new QuestionBank("What was the day on 15th august 1947 ?","Friday","Saturday","Sunday","Thrusday",4d,"Friday","");
		
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
		questions.add(question6);
		questions.add(question7);
		questions.add(question8);
		questions.add(question9);
		questions.add(question10);
		
		
		Set<QuestionBank> questions1 = new HashSet<QuestionBank>();
		questions1.add(question6);
		questions1.add(question7);
		questions1.add(question8);
		questions1.add(question9);
		questions1.add(question10);
		questions1.add(question12);
		questions1.add(question15);
		questions1.add(question20);
		questions1.add(question21);
		questions1.add(question22);
		
		TestBank test1 = new TestBank("General Aptitude I" , LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), questions);
		myManager.persist(test1);
		
		TestBank test2 = new TestBank("General Aptitude II" ,LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), questions1);
		myManager.persist(test2);
		
		User suraj = new User("Suraj_Pakhare","12345",true);
		myManager.persist(suraj);
		
		User danish = new User("Danish_Sharma","12345",false);
		myManager.persist(danish);
		
		User sachin = new User("Sachin_Kumar","12345",false);
		myManager.persist(sachin);
		
	    WorkSpaceData dataA = new WorkSpaceData(Long.valueOf(2), BigInteger.valueOf(1) , "General Aptitude I" , Double.valueOf(40), LocalTime.of(00, 40, 00),Integer.valueOf(0));
		myManager.persist(dataA);
		
		WorkSpaceData dataB = new WorkSpaceData(Long.valueOf(2), BigInteger.valueOf(2) , "General Aptitude II" , Double.valueOf(40), LocalTime.of(00, 40, 00),Integer.valueOf(0));
		myManager.persist(dataB);
		
		WorkSpaceData dataC = new WorkSpaceData(Long.valueOf(3),BigInteger.valueOf(2),"General Aptitude II",Double.valueOf(40), LocalTime.of(00, 40, 00),Integer.valueOf(0));
		myManager.persist(dataC);
		
		WorkSpaceData dataD = new WorkSpaceData(Long.valueOf(3),BigInteger.valueOf(1),"General Aptitude I",Double.valueOf(40), LocalTime.of(00, 40, 00),Integer.valueOf(0));
		myManager.persist(dataD);
	}
}
