package com.example.hostel.service;

import com.example.hostel.model.Warden;
import com.example.hostel.repository.WardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class wardenService {

    @Autowired
    private WardenRepository wardenRepository;

    public Warden login(String username, String password) {
        Optional<Warden> warden = wardenRepository.findById(username);
        return warden.filter(w -> w.getPassword().equals(password)).orElse(null);
    }
}
