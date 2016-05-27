package org.sourceit.command.impl.profession;

import org.sourceit.command.ICommand;
import org.sourceit.db.ProfessionDBProvider;
import org.sourceit.entities.Profession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProfessionCommand implements ICommand {
    private ProfessionDBProvider provider = ProfessionDBProvider.INSTANCE;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        try {
            Long applicantId = Long.parseLong(request.getParameter("id"));
            Profession profession = provider.getProfession(applicantId);
            request.setAttribute("profession",profession);
        } catch (Exception e) {
            request.setAttribute("error", e);
            return "pages/error.jsp";
        }

        request.setAttribute("title", "Edit Profession");
        return "pages/applicant/edit_profession.jsp";
    }
}
