package org.sourceit.command.impl.Subject;

import org.sourceit.command.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSubjectCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/applicant/edit_subject.jsp";
    }
}
