package org.sourceit.command.impl;

import org.sourceit.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main_Dashbord implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse resp) {
        return "pages/index.jsp";
    }
}
