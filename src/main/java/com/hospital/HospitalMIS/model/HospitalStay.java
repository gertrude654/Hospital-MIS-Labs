package com.hospital.HospitalMIS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalStay {

    @EmbeddedId
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_no", referencedColumnName = "patient_no", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ward_no", referencedColumnName = "ward_no", nullable = false),
            @JoinColumn(name = "bed_no", referencedColumnName = "bed_no", nullable = false)
    })
    private Ward ward;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    // Additional methods can be added as needed
}
