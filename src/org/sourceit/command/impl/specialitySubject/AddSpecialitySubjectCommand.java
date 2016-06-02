package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ProfessionDBProvider;
import org.sourceit.db.SubjectDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddSpecialitySubjectCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        request.setAttribute("title", "Add applicant");
        List<Profession> professions = null;
        List<Subject> subjects = null;

        try {
            subjects = SubjectDBProvider.INSTANCE.getSubjects();
            professions = ProfessionDBProvider.INSTANCE.getProfessions();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }
        request.setAttribute("professions1", professions);
        request.setAttribute("subjects", subjects);
        request.setAttribute("title", "Add Speciality Subject");
        return "pages/applicant/edit_specialitySubject.jsp";
    }
}
