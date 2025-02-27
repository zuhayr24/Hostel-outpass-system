package com.example.hostel.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "outpass")
public class Outpass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // NEW: Use name for student identification instead of studentRegNo
    private String name;

    private LocalDate fromDate;
    private LocalDate toDate;
    private int totalDays;
    private String placeOfVisit;
    private String purpose;
    private String emergencyContact;
    private String status = "Pending";

    // Constructors
    public Outpass() {}

    public Outpass(String name, LocalDate fromDate, LocalDate toDate, int totalDays,
                   String placeOfVisit, String purpose, String emergencyContact) {
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalDays = totalDays;
        this.placeOfVisit = placeOfVisit;
        this.purpose = purpose;
        this.emergencyContact = emergencyContact;
        this.status = "Pending";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }
    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }
    public int getTotalDays() { return totalDays; }
    public void setTotalDays(int totalDays) { this.totalDays = totalDays; }
    public String getPlaceOfVisit() { return placeOfVisit; }
    public void setPlaceOfVisit(String placeOfVisit) { this.placeOfVisit = placeOfVisit; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    // NEW: Add field for wardenReason
    private String wardenReason;

    // NEW: Getter and Setter for wardenReason
    public String getWardenReason() {
        return wardenReason;
    }

    public void setWardenReason(String wardenReason) {
        this.wardenReason = wardenReason;
    }

}
