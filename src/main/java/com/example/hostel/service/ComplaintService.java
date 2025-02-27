package com.example.hostel.service;

import com.example.hostel.model.Complaint;
import com.example.hostel.model.Outpass;
import com.example.hostel.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public void saveComplaint(Complaint complaint) {
        complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }



    // New method to fetch complaints by student name
    public List<Complaint> getComplaintsByName(String name) {
        return complaintRepository.findByName(name);
    }
    public void updateStatus(Long id, String status) {
        Optional<Complaint> optionalComplaint = complaintRepository.findById(id);
        if (optionalComplaint.isPresent()) {
            Complaint complaint = optionalComplaint.get();
            complaint.setStatus(status);
            // Optionally, set a default response text when updated
            // For example, if resolved, you might want to set a specific message:
            if ("Resolved".equalsIgnoreCase(status)) {
                // You can either set a separate field (if defined) or simply rely on the status
                // complaint.setWardenResponse("Resolved"); // if you have such a field
            }
            complaintRepository.save(complaint);
        }
    }

}
