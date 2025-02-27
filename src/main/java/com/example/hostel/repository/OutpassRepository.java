package com.example.hostel.repository;

import com.example.hostel.model.Outpass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OutpassRepository extends JpaRepository<Outpass, Long> {
    List<Outpass> findByName(String name);
}
