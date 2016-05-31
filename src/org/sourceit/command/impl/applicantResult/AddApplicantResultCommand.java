package org.sourceit.command.impl.applicantResult;

import org.sourceit.command.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddApplicantResultCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        request.setAttribute("title", "Add Applicant Result");

        return "pages/applicant/edit_applicantResult.jsp";
    }
}
