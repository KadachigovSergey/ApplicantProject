package org.sourceit.command.impl.specialitySubject;

import org.sourceit.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSpecialitySubjectCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/applicant/edit_specialitySubject.jsp";
    }
}
