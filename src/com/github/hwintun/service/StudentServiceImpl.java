package com.github.hwintun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.hwintun.mappers.StudentMapper;
import com.github.hwintun.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional	
	@Override
	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	@Override
	public boolean getStudentByLogin(String userName, String password) {
		Student student = studentMapper.getStudentByUserName(userName);
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean getStudentByUserName(String userName) {
		Student student = studentMapper.getStudentByUserName(userName);
		if(student != null) {
			return true;
		}
		return false;
	}

}
