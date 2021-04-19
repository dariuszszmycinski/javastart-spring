package dasz.service;

import dasz.constraint.group.Draft;
import dasz.constraint.group.Full;
import dasz.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ProjectService {

    private Validator validator;

    @Autowired

    public ProjectService(Validator validator) {
        this.validator = validator;
    }

    public boolean validateDraft(Project project) {
        Set<ConstraintViolation<Project>> errors = validator.validate(project, Draft.class);
        errors.forEach(err -> System.err.println(err.getPropertyPath() + " " + err.getMessage()));
        return errors.isEmpty();
    }

    public boolean validateFull(Project project) {
        Set<ConstraintViolation<Project>> errors = validator.validate(project, Full.class);
        errors.forEach(err -> System.err.println(err.getPropertyPath() + " " + err.getMessage()));
        return errors.isEmpty();
    }
}
