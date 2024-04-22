package com.crudop.crudoperations.repository;



import com.crudop.crudoperations.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {


    @Query("from Student")
    List<Student> findAllStudent();

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]>findAllPartialData();

    @Query("from Student where firstName=:firstName")
    List<Student> findFirstName(@Param("firstName") String firstName);


    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentscor(@Param("min") int min, @Param("max")int max);

    @Modifying
    @Query("delete from Student where firstName=:firstName")
    void deleteByfirstname(@Param("firstName") String firstName);

    //nativequery
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllstudentNQ();


    @Query(value="select * from student where fname =:firstName ", nativeQuery = true)
    List<Student> findByfirstNameNQ(@Param("firstName")String firstName);
}
