package com.example.hostel.service;

import com.example.hostel.model.Outpass;
import com.example.hostel.repository.OutpassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;  // Ensure this import is present

@Service
public class OutpassService {

    @Autowired
    private OutpassRepository outpassRepository;

    public Outpass submitOutpass(Outpass outpass) {
        return outpassRepository.save(outpass);
    }

    public List<Outpass> getStudentOutpasses(String name) {
        return outpassRepository.findByName(name);
    }

    // NEW: Fetch all outpass records (for the warden view)
    public List<Outpass> getAllOutpasses() {
        return outpassRepository.findAll();
    }

    public void updateStatus(Long id, String status) {
        Optional<Outpass> optionalOutpass = outpassRepository.findById(id);
        if (optionalOutpass.isPresent()) {
            Outpass outpass = optionalOutpass.get();
            outpass.setStatus(status);
            // Set wardenReason to a default response text when updated.
            outpass.setWardenReason("Responded");
            outpassRepository.save(outpass);
        }
    }
}
