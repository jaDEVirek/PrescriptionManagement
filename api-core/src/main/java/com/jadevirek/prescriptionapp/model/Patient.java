package src.main.java.com.jadevirek.prescriptionapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private String fName;
    private String sName;
    private String pesel;
    private String email;
    private String address;
    private String age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prescription> prescriptions = new HashSet<>();


    public Patient() {
    }

}
