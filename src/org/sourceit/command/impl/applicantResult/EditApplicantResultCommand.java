package org.sourceit.command.impl.applicantResult;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.db.ApplicantResultDBProvider;
import org.sourceit.db.SubjectDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.ApplicantResult;
import org.sourceit.entities.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class EditApplicantResultCommand implements ICommand {
    private ApplicantResultDBProvider provider = ApplicantResultDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        List<Applicant> applicants;
        List<Subject> subjects;

        try {
            subjects = SubjectDBProvider.INSTANCE.getSubjects();
            applicants = ApplicantDBProvider.INSTANCE.getApplicants();
            Long applicantResultId = Long.parseLong(request.getParameter("id"));
            ApplicantResult applicantResult = provider.getApplicantResult(applicantResultId);
            request.setAttribute("applicantResult", applicantResult);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicants", applicants);
        request.setAttribute("subjects", subjects);
        request.setAttribute("title", "Edit applicant");
        return "pages/applicant/edit_applicantResult.jsp";
    }
}
