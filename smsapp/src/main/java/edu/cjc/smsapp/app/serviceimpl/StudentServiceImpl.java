package edu.cjc.smsapp.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.smsapp.app.model.Student;
import edu.cjc.smsapp.app.repositary.StudentRepositary;
import edu.cjc.smsapp.app.servicei.StudentServiceI;
@Service
public class StudentServiceImpl  implements StudentServiceI{

	@Autowired
	StudentRepositary sr;
	@Override
	public void saveStudent(Student s) {
		sr.save(s);
	}
	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
	}
	@Override
	public List<Student> searchBatch(String batchNumber) {
		return sr.findAllByBatchNumber(batchNumber);
	}
	@Override
	public Student getSingleStudent(int id) {
		return sr.findById(id).get();
	}
	@Override
	public void updateStudentfees(int studentId, double ammount) {
          Student  s          = sr.findById(studentId).get();
		       s.setFeesPaid(s.getFeesPaid()+ammount);
		       
		       sr.save(s);
	}
	@Override
	public void removeStudent(int studentId) {

		sr.deleteById(studentId);
	}
	@Override
	public void updateStudentBatch(int studentId, String batchNumber) {
		 Student  s          = sr.findById(studentId).get();
	       s.setBatchNumber(batchNumber);
	       
	       sr.save(s);
	}

}
