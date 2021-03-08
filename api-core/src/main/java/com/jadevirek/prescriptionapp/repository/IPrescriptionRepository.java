package src.main.java.com.jadevirek.prescriptionapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.main.java.com.jadevirek.prescriptionapp.model.Prescription;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription,Long> {
}
