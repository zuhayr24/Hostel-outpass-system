package com.example.hostel.controller;

import com.example.hostel.model.Outpass;
import com.example.hostel.service.OutpassService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/outpass")
@CrossOrigin("*")
public class OutpassController {

    @Autowired
    private OutpassService outpassService;

    // API endpoint for submitting an outpass request
    @PostMapping("/submit")
    @ResponseBody
    public Outpass submitOutpass(@RequestBody Outpass outpass, HttpSession session) {
        String studentName = (String) session.getAttribute("studentName");
        outpass.setName(studentName);
        return outpassService.submitOutpass(outpass);
    }

    // Display outpass records for the logged-in student filtered by name
    @GetMapping("/student-outpasses")
    public String viewStudentOutpasses(HttpSession session, Model model) {
        String studentName = (String) session.getAttribute("studentName");
        if (studentName == null) {
            return "redirect:/student-login";
        }
        List<Outpass> outpasses = outpassService.getStudentOutpasses(studentName);
        model.addAttribute("outpasses", outpasses);
        return "view-outpass";
    }

    // Endpoint to update the status of an outpass (Accept/Reject)
    @GetMapping("/update-status/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        outpassService.updateStatus(id, status);
        return "redirect:/outpass/requests";
    }

    // Display all outpass records (for warden view)
    @GetMapping("/requests")
    public String viewAllOutpasses(Model model) {
        List<Outpass> outpasses = outpassService.getAllOutpasses();
        model.addAttribute("outpasses", outpasses);
        return "view-req";
    }
}
