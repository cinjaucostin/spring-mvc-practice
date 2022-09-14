package com.test.costin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Value("#{countries}")
    private Map<String, String> countries;

    @Value("#{programminglanguages}")
    private Map<String, String> programmingLanguages;

    @Value("#{operatingSystems}")
    private Map<String, String> operatingSystems;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        // create a new student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        theModel.addAttribute("countries", countries);

        theModel.addAttribute("programmingLanguages", programmingLanguages);

        theModel.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data

        System.out.println("theStudent: " + theStudent.getFirstName() +
                " " + theStudent.getLastName() + " from: " + theStudent.getCountry());

        return "student-confirmation";
    }

}
