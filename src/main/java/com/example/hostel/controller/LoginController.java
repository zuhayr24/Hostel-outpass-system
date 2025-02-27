package com.example.hostel.controller;

import com.example.hostel.model.Student;
import com.example.hostel.model.Warden;
import com.example.hostel.service.wardenService;
import com.example.hostel.service.studentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private wardenService wardenService;
    @Autowired
    private studentService studentService;

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/view-req")
    public String viewRequests() {
        return "view-req";
    }
    @GetMapping("/out-req")
    public String outRequests() {
        return "out-req";
    }
    @GetMapping("/view-complaints-warden")
    public String viewComplaints() {
        return "view-complaints-warden";
    }
    @GetMapping("/view-outpass")
    public String viewoutpass() {
        return "view-outpass";
    }
    @GetMapping("/warden-dashboard")
    public String wdashboard() {
        return "warden-dashboard";
    }
    @GetMapping("/student-dashboard")
    public String sdashboard() {
        return "student-dashboard";
    }
    @GetMapping("/warden-login")
    public String wardenLogin(Model model) {
        model.addAttribute("user", new Warden());
        return "warden-login";
    }
    @PostMapping("/warden-login")
    public String login(@ModelAttribute("user") Warden user, Model model) {
        Warden authenticatedUser = wardenService.login(user.getUsername(), user.getPassword());
        if (Objects.nonNull(authenticatedUser)) {
            return "warden-dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "warden-login";
        }
    }
    @GetMapping("/student-login")
    public String studentLogin(Model model) {
        model.addAttribute("student", new Student());
        return "student-login";
    }
    @PostMapping("/student-login")
    public String login(@ModelAttribute("student") Student user, HttpSession session, Model model) {
        Student authenticatedUser = studentService.login(user.getUsername(), user.getPassword());
        if (Objects.nonNull(authenticatedUser)) {
            // Store the student's name in session (used for filtering later)
            session.setAttribute("studentName", authenticatedUser.getUsername());
            return "student-dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "student-login";
        }
    }
}
