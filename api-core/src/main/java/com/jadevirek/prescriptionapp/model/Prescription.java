package src.main.java.com.jadevirek.prescriptionapp.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @ManyToOne
    private Doctor doctor;

    private String serialNumber;
    private String description;

    private LocalDateTime date;
    private LocalDateTime expirationDate;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "prescription",cascade = CascadeType.ALL)
    private Set<Medicament> medicaments = new HashSet<>();;



}
