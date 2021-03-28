package src.main.java.com.jadevirek.prescriptionapp.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Version
    private Long version;

    @NotBlank
    @Column(name = "Type", length = 1)
    private String type;

    @NotBlank
    @Column(name = "Name", length = 200)
    private String name;

    @NotBlank
    @Column(name = "Maker", length = 200)
    private String maker;

    @NotNull
    @Column(name = "Dosage", length = 200)
    private String defaultDosage;

    @NotNull
    @Column(name = "Refundation")
    private boolean isRefunded;

    @NotNull
    @Column(name = "Price")
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

}
