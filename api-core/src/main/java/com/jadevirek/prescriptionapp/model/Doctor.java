package src.main.java.com.jadevirek.prescriptionapp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    private String age;

    private String gender;

    private String officePhone;

    private String specialization;

    private String medicalDepartment;

    private String pwzNumber;


    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private Set<Prescription> prescriptions = new HashSet<>();
}
