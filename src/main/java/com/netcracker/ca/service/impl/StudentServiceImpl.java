package com.netcracker.ca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.ca.dao.StudentDao;
import com.netcracker.ca.dao.TeamDao;
import com.netcracker.ca.model.Student;
import com.netcracker.ca.model.Team;
import com.netcracker.ca.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeamDao teamDao;

	@Override
	public Student getById(int id) {
		return studentDao.getById(id);
	}

	@Override
	public Student getByAppFormId(int appFormId) {
		return studentDao.getByAppFormId(appFormId);
	}

	@Override
	public void add(Student student) {
		studentDao.add(student);
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public List<Student> getByProject(int projectId) {
		return studentDao.getByProject(projectId);
	}

	@Override
	public List<Student> getByTeam(int teamId) {
		return studentDao.getByTeam(teamId);
	}

	@Override
	public Team getCurrent(int studentId) {
		return teamDao.getCurrentForStudent(studentId);
	}

}