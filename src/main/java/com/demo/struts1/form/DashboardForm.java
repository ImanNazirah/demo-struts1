package com.demo.struts1.form;

import org.apache.struts.action.ActionForm;

public class DashboardForm extends ActionForm {

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}