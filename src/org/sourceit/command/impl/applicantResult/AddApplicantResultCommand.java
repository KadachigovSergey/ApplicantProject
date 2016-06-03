package org.sourceit.command.impl.applicantResult;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.db.SubjectDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddApplicantResultCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        request.setAttribute("title", "Add Applicant Result");
        List<Applicant> applicants;
        List<Subject> subjects;
        try {
            subjects = SubjectDBProvider.INSTANCE.getSubjects();
            applicants = ApplicantDBProvider.INSTANCE.getApplicants();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }
        request.setAttribute("applicants", applicants);
        request.setAttribute("subjects", subjects);


        return "pages/applicant/edit_applicantResult.jsp";
    }
}
