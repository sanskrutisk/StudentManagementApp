package edu.cjc.smsapp.app.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.smsapp.app.model.Student;
@Repository
public interface StudentRepositary  extends JpaRepository<Student,Integer>
{
public List<Student> findAllByBatchNumber(String batchNumber);
}
