package controller;

import frontcontroller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormController implements Controller {

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("new-form");
    }
}