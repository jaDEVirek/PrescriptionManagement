package src.main.java.com.jadevirek.prescriptionapp.model;


import src.main.java.com.jadevirek.prescriptionapp.model.dto.PatientDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Doctors")
public class Doctor {

    public Doctor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @NotBlank
    @Column(name = "first_name")
    private String fName;

    @NotBlank
    @Column(name = "second_name")
    private String sName;

    private String age;

    private String gender;

    @NotBlank
    @Size(min = 9)
    private String officePhone;

    @NotBlank
    private String specialization;

    @NotBlank
    private String medicalDepartment;

    @NotBlank
    private String pwzNumber;


    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions = new HashSet<>();

}
