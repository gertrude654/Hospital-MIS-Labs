package com.hospital.HospitalMIS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_tbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_no")
    private int emNo;

    @Column(name = "first_name", nullable = false, length = 50)
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "dep_code", referencedColumnName = "dep_code"),
            @JoinColumn(name = "dep_num", referencedColumnName = "dep_num")
    })
    private Department department;

}
