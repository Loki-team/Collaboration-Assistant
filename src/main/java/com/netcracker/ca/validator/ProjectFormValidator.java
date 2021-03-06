package com.netcracker.ca.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.netcracker.ca.model.Project;

@Component
public class ProjectFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Project project = (Project) target;
		String title = project.getTitle().replaceAll(" ", "").toLowerCase();
		project.setTitle(title.substring(0, 1).toUpperCase() + title.substring(1));

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.projectForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty.projectForm.startDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "NotEmpty.projectForm.endDate");

		if (project.getTitle().length() > 64) {
			errors.rejectValue("title", "Size.projectForm.title");
		}

		if (project.getDescription().length() > 300) {
			errors.rejectValue("title", "Size.projectForm.description");
		}
	}
}