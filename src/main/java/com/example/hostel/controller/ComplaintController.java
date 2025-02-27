package com.example.hostel.controller;

import com.example.hostel.model.Complaint;
import com.example.hostel.model.Outpass;
import com.example.hostel.service.ComplaintService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/complaint")
    public String showComplaintForm(Model model) {
        model.addAttribute("complaint", new Complaint());
        return "complaint-request";
    }

    @PostMapping("/submit-complaint")
    public String submitComplaint(@ModelAttribute Complaint complaint, HttpSession session, Model model) {
        String studentName = (String) session.getAttribute("studentName");
        complaint.setName(studentName);
        complaintService.saveComplaint(complaint);
        model.addAttribute("message", "Complaint submitted successfully!");
        model.addAttribute("complaint", new Complaint());
        return "complaint-request";
    }


    // New: View only complaints submitted by the logged-in student
    @GetMapping("/student-complaints")
    public String viewStudentComplaints(HttpSession session, Model model) {
        String studentName = (String) session.getAttribute("studentName");
        if (studentName == null) {
            return "redirect:/student-login";
        }
        List<Complaint> complaints = complaintService.getComplaintsByName(studentName);
        model.addAttribute("complaints", complaints);
        return "view-complaints";
    }

    @GetMapping("/requests")
    public String viewAllComplaints(Model model) {
        List<Complaint> complaints = complaintService.getAllComplaints();
        model.addAttribute("complaints", complaints);
        return "view-complaints-warden";
    }
    @GetMapping("/complaint/update-status/{id}")
    public String updateComplaintStatus(@PathVariable Long id, @RequestParam String status) {
        complaintService.updateStatus(id, status);
        // Redirect back to the warden complaints view page (adjust the path as needed)
        return "redirect:/requests";
    }

}
