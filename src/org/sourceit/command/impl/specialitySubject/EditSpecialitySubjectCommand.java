package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;
import org.sourceit.db.SpecialitySubjectDBProvider;
import org.sourceit.entities.SpecialitySubject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        request.setAttribute("title", "Edit Speciality Subject");
        return "pages/applicant/edit_specialitySubject.jsp";
    }
}
