package org.sourceit.command.impl.applicantResult;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantResultDBProvider;
import org.sourceit.entities.ApplicantResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveApplicantResultCommand implements ICommand {
    private ApplicantResultDBProvider provider = ApplicantResultDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        ApplicantResult applicantResult = new ApplicantResult();
        try {
            applicantResult.setApplicantId(Long.parseLong(request.getParameter("applicant")));
            applicantResult.setSubjectId(Long.parseLong(request.getParameter("subject1")));
            applicantResult.setMark(Integer.parseInt(request.getParameter("mark")));
        }catch (NumberFormatException nfe){
        request.setAttribute("title", "Add Applicant Result");
        return "pages/applicant/edit_applicantResult.jsp";
    }
        if (request.getParameter("applicant_result_id") != null) {
            applicantResult.setId(Long.parseLong(request.getParameter("applicant_result_id")));
        }
        try {
            provider.saveApplicantResult(applicantResult);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }
        return "controller?command=applicantResults";
    }
}
