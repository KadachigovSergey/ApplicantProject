package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.SpecialitySubjectDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.SpecialitySubject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveSpecialitySubjectCommand implements ICommand {
    private SpecialitySubjectDBProvider provider = SpecialitySubjectDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        SpecialitySubject specialitySubject = new SpecialitySubject();

        specialitySubject.setProfessionId(Long.parseLong(request.getParameter("Profession_id")));
        specialitySubject.setSubjectId(Long.parseLong(request.getParameter("Subject_id")));
        if (request.getParameter("SP_SB_ID") != null) {
            specialitySubject.setId(Long.parseLong(request.getParameter("SP_SB_ID")));
        }
        try {
            provider.saveSpecialitySubject(specialitySubject);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        return "controller?command=specialitySubjects";
    }
}
