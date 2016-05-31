package org.sourceit.command.impl.applicantResult;

import org.sourceit.command.ICommand;
import org.sourceit.db.ApplicantResultDBProvider;
import org.sourceit.entities.ApplicantResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class ApplicantResultCommand implements ICommand {
    private ApplicantResultDBProvider provider = ApplicantResultDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {

        List<ApplicantResult> applicantResults;

        try {
            System.out.println(provider.getApplicantResults());
            applicantResults = provider.getApplicantResults();
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("applicantResults", applicantResults);

        return "pages/applicant/applicantResults.jsp";
    }
}