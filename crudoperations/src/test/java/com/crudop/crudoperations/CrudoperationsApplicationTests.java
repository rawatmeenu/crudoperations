package com.crudop.crudoperations;


import com.crudop.crudoperations.model.Student;
import com.crudop.crudoperations.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudoperationsApplicationTests {


	@Autowired
	StudentRepository repo;

	@Test
	public void testallStudent(){
		System.out.println(repo.findAllStudent());
	}

	@Test
	public void testPartial(){
		List<Object[]> partialData = repo.findAllPartialData();
		for(Object[] obj: partialData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}


	}

	@Test
	public void testfindByfirstName()
	{
		System.out.println(repo.findFirstName("uusni"));

	}

	@Test
	public void testfindstudentscore(){

		System.out.println(repo.findStudentscor(50,60));

	}

	@Transactional
	@Test
	@Rollback(false)
	public void testdeletebyFirstname()
	{
		repo.deleteByfirstname("uusni");
	}

	@Test
	public void testfindallstudentNQ(){
		System.out.println(repo.findAllstudentNQ());
	}

	@Test
	public void findByfirstnameNQ()
	{
		System.out.println(repo.findByfirstNameNQ("vikram"));
	}

//	@Test
//	public void createst() {
//		Student emp = new Student();
//		//emp.setId(123l);
//		emp.setFirstName("meenu");
//		emp.setLastName("rawat");
//		emp.setScore(90);
//		repo.save(emp);
//
//
//		Student emp2 = new Student();
//		//emp.setId(123l);
//		emp2.setFirstName("neha");
//		emp2.setLastName("singh");
//		emp2.setScore(90);
//		repo.save(emp2);
//	}
	}

