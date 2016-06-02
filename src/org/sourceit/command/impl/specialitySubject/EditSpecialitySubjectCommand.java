package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.ProfessionDBProvider;
import org.sourceit.db.SpecialitySubjectDBProvider;
import org.sourceit.db.SubjectDBProvider;
import org.sourceit.entities.Profession;
import org.sourceit.entities.SpecialitySubject;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditSpecialitySubjectCommand implements ICommand {
    private SpecialitySubjectDBProvider provider = SpecialitySubjectDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        try {
            Long specialitySubjectId = Long.parseLong(request.getParameter("id"));
            SpecialitySubject specialitySubject = provider.getSpecialitySubject(specialitySubjectId);
            request.setAttribute("specialitySubject", specialitySubject);
        } catch (Exception e) {
            return "pages/error.jsp";
        }
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
        request.setAttribute("title", "Edit Speciality Subject");
        return "pages/applicant/edit_specialitySubject.jsp";
    }
}
