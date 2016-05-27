package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.SpecialitySubjectDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.SpecialitySubject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditSpecialitySubjectCommand implements ICommand {
    private SpecialitySubjectDBProvider provider = SpecialitySubjectDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        try {
            Long SpecialitySubjectId = Long.parseLong(request.getParameter("id"));
            SpecialitySubject specialitySubject = provider.getSpecialitySubject(SpecialitySubjectId);
            request.setAttribute("specialitySubject", specialitySubject);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("title", "Edit speciality subject");
        return "pages/applicant/edit_specialitySubject.jsp";
    }
}
