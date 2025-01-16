package com.tpe.repository;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//opsiyonel
public interface StudentRepository extends JpaRepository<Student,Long> {

    //JpaRepositorydeki metodlar Spring tarafından otomatik olarak implemente edilir


    //5-
    boolean existsByEmail(String email);


    //15-a
    List<Student> findAllByGrade(Integer grade);//select * from Student where grade=100

    //15-b
    //JPQL:javaca
    @Query("FROM Student WHERE grade=:pGrade")
    List<Student> filterStudentsByGrade(@Param("pGrade") Integer grade);
    //@Param methodun parametresinde verilen degeri pGrade icerisine alir
    // ve bu degiskeni sorgu icerisinde kullanabiliriz

    //15-c
    //SQL:value özelliği ile SQL ifadesi String olarak verilir ve nativeQuery
    //true olarak aktif edilir.
    @Query(value = "SELECT * FROM student WHERE grade=:pGrade",nativeQuery = true)
    List<Student> filterStudentsByGradeSQL(@Param("pGrade") Integer grade);

    //18-c:JPQL ile tablodan gelen Entity objesini DTO nun constructorı
    //ile doğrudan DTO objesine dönüştürelim
    @Query("SELECT new com.tpe.dto.StudentDTO(s) FROM Student s WHERE s.id=:pId")
    Optional<StudentDTO> findStudentDtoById(@Param("pId") Long id);
}










