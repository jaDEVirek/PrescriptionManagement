package src.main.java.com.jadevirek.prescriptionapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @NotBlank
    @Column(name="first_name")
    private String fName;

    @NotBlank
    @Column(name="second_name")
    private String sName;

    @NotBlank
    @Column(name="pesel")
    private String pesel;

    @Column(name = "email",nullable = false)
    private String email;

    @NotBlank
    private String address;

    private String age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prescription> prescriptions = new HashSet<>();

    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Patient() {
    }



    /**
     * Creating for Testing using Jackson, which requires a default constructor
     */



    @PrePersist
    public void persistOnCreate() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void updateOnModify() {
        this.modifiedOn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getId().equals(patient.getId()) &&
                version.equals(patient.version) &&
                getfName().equals(patient.getfName()) &&
                getsName().equals(patient.getsName()) &&
                getPesel().equals(patient.getPesel()) &&
                getEmail().equals(patient.getEmail()) &&
                getAddress().equals(patient.getAddress()) &&
                Objects.equals(getAge(), patient.getAge()) &&
                getPrescriptions().equals(patient.getPrescriptions()) &&
                Objects.equals(getCreatedOn(), patient.getCreatedOn()) &&
                Objects.equals(getModifiedOn(), patient.getModifiedOn());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), version, getfName(), getsName(), getPesel(), getEmail(), getAddress(), getAge(),
                getPrescriptions(), getCreatedOn(), getModifiedOn());
    }
}
