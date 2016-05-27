package org.sourceit.command.impl.applicant;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddApplicantCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        request.setAttribute("title", "Add applicant");

        return "pages/applicant/edit_applicant.jsp";
    }
}