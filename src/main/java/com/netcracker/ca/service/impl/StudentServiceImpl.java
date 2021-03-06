package com.netcracker.ca.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netcracker.ca.dao.ProjectStatusDao;
import com.netcracker.ca.dao.StudentDao;
import com.netcracker.ca.model.Participation;
import com.netcracker.ca.model.ProjectStatus;
import com.netcracker.ca.model.Student;
import com.netcracker.ca.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ProjectStatusDao projectStatusDao;

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
	public Map<Student, Participation> getByProjectWithParticipation(int projectId) {
		return studentDao.getByProjectWithParticipation(projectId);
	}

	@Override
	public Map<Student, Participation> getByTeamWithParticipation(int teamId) {
		return studentDao.getByTeamWithParticipation(teamId);
	}

	@Override
	public List<Student> getByTeamAndStatus(int teamId, String status) {
		ProjectStatus projectStatus = projectStatusDao.getByDesc(status);
		if(projectStatus == null)
			return Collections.emptyList();
		return studentDao.getByTeamAndStatus(teamId, projectStatus.getId());
	}

	@Override
	public List<Student> getByMeeting(int meetingId) {
		return studentDao.getByMeeting(meetingId);
	}

	@Override
	public List<Student> getFreeStudents() {
		return studentDao.getFreeStudents();
	}

}