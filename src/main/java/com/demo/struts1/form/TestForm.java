package com.demo.struts1.form;

import org.apache.struts.action.ActionForm;

public class TestForm extends ActionForm {

    String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}