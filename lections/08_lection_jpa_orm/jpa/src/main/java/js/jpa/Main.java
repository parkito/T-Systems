package js.jpa;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import js.jpa.pk.relation.Addr;
import js.jpa.pk.relation.Lection;
import js.jpa.pk.relation.Pers;
import js.jpa.pk.relation.WorkGroup;
import js.jpa.pk.relation.Student;
import js.jpa.pk.relation.inheritance.Animal;
import js.jpa.pk.relation.inheritance.Bear;
import js.jpa.pk.relation.inheritance.Forest;
import js.jpa.pk.relation.inheritance.Fox;

public class Main {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myapp");

	public static void main(String[] args) {
		/*
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		Person person = new Person();
		person.setName("alex");
		
		Map<PhoneType ,Phone> phones = new EnumMap<PhoneType, Phone>(PhoneType.class);
		phones.put(PhoneType.HOME, new Phone(PhoneType.HOME, "11","222"));
		phones.put(PhoneType.MOBILE, new Phone(PhoneType.MOBILE, "22", "333"));
		phones.put(PhoneType.WORK, new Phone(PhoneType.WORK, "11", "444"));
		
		person.setPhones(phones);
		em.persist(person);
		long id  = person.getId();
		
		Employee employee = new Employee();
		employee.setId(3);
		employee.setName("qwertyuiopasdfghjk");
		employee.setSurname("qwer11");
		em.persist(employee);
		
		
		trx.commit();
		em.close();
		
		em = emf.createEntityManager();
		person = em.find(Person.class, id);
		Map<PhoneType, Phone> phoneMap = person.getPhones();
		System.out.println(phoneMap.get(PhoneType.HOME).getNumber());	
		*/
		
		//abstractEntityTest();
		
		//relationTest();
		//simpleRemove();
		//cascadeRemove();
		//orphanRemove();
		
		//manyToManyTest();
		
		//relationTest();
		
		// manyToManyTest();
		
		orftest();
		
	}
	
	
	private static void orftest() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
			Addr addr = new Addr();
			addr.setAddr("addr1");
			
			
			Addr addr2 = new Addr();
			addr2.setAddr("addr2");
		
			Pers pers = new Pers();
			pers.setAddr(Arrays.asList(addr, addr2));
			pers.setName("name1");
			
			addr.setPers(pers);
			addr2.setPers(pers);
			
			//addr.setPers(pers);
			
			em.persist(pers);
			//em.persist(addr);
			
		trx.commit();
	
		em = emf.createEntityManager();
		trx = em.getTransaction();	
		trx.begin();
		
		   pers = em.find(Pers.class, pers.getId());
		   
		   System.out.println( pers.getAddr());
		   //em.remove(pers);
		   
		   Addr a = pers.getAddr().iterator().next();
		   pers.getAddr().remove(a);
		   //addr = em.find(Addr.class, addr.getId());
		   //em.remove(addr);
		trx.commit();
		
		em = emf.createEntityManager();
		//trx = em.getTransaction();	
			pers = em.find(Pers.class, pers.getId());
			System.out.println( pers.getAddr());
		//trx.commit();
		
	}
	
	private static void abstractEntityTest() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		
		Forest forest = new Forest();
		forest.setId("1");
		
		em.persist(forest);
		
		Fox fox = new Fox();
		fox.setId("1");
		fox.setWoolColor("red");
		fox.setForest(forest);
		fox.setFoxFeature("f1");	
		em.persist(fox);
		
		Bear bear = new Bear();
		bear.setId("2");
		bear.setWoolColor("brown");
		bear.setForest(forest);
		bear.setBearFeature("b1");
		em.persist(bear);
		
		trx.commit();
		
		em = emf.createEntityManager();
		trx = em.getTransaction();
		trx.begin();
		
		forest = em.find(Forest.class, "1");
		for (Animal animal : forest.getAnimals()) {
			if (animal instanceof Bear) {
				System.out.println("Bear is found");
			} else if (animal instanceof Fox) {
				System.out.println("Fox is found");
			} else {
				System.out.println("Unknown animal is found");
			}
			em.remove(animal);
		}
		em.remove(forest);
		
		trx.commit();
	}
	
	private static void manyToManyTest() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("name1");
		
		Student s2 = new Student();
		s2.setId("2");
		s2.setName("name2");
		
		Lection l1 = new Lection();
		l1.setId("1");
		l1.setSubject("sj1");
		
		Lection l2 = new Lection();
		l2.setId("2");
		l2.setSubject("sj2");
		
		s1.setLections(Arrays.asList(l1, l2));
		s2.setLections(Arrays.asList(l1, l2));
		
		em.persist(s1);
		em.persist(s2);
		em.persist(l1);
		em.persist(l2);
		
		
		trx.commit();
	}
	
	
	private static void relationTest() {
		
		//create
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		
			WorkGroup group = new WorkGroup();
			group.setId("1");
			group.setNumber(1);
			
			Student s1 = new Student();
			s1.setId("1");
			s1.setName("name1");
			s1.setWorkGroup(group);
			
			Student s2 = new Student();
			s2.setId("2");
			s2.setName("name2");
			s2.setWorkGroup(group);
						
			group.setStudent(Arrays.asList(s1, s2));
			
			em.persist(group);
			em.persist(s1);
			em.persist(s2);
		
		trx.commit();
		
		//find group
		em = emf.createEntityManager();	
		group = em.find(WorkGroup.class, "1");
		List<Student> students = group.getStudent();
		
		
		//find student
		em = emf.createEntityManager();	
		s1 = em.find(Student.class, "1");
		group = s1.getWorkGroup();

	}
	
	private static void simpleRemove() {
		EntityManager em = emf.createEntityManager();	
		EntityTransaction trx = em.getTransaction();
		
		trx.begin();
			WorkGroup group = em.find(WorkGroup.class, "1");
		    List<Student> students = group.getStudent();
		    for(Student s : students) {
		    	em.remove(s);
		    }
		    em.remove(group);
		trx.commit();
	}
	
	private static void cascadeRemove() {
		EntityManager em = emf.createEntityManager();	
		EntityTransaction trx = em.getTransaction();
		
		trx.begin();
			WorkGroup group = em.find(WorkGroup.class, "1");
		    em.remove(group);
		trx.commit();
	}
	
	private static void orphanRemove() {
		EntityManager em = emf.createEntityManager();	
		EntityTransaction trx = em.getTransaction();
		
		trx.begin();
			WorkGroup group = em.find(WorkGroup.class, "1");
		    List<Student> students = group.getStudent();
		    students.clear();
		    em.remove(group);
		trx.commit();
	}
}
