package src.main.java.com.jadevirek.prescriptionapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.jadevirek.prescriptionapp.common.CreateEntityException;
import src.main.java.com.jadevirek.prescriptionapp.model.dto.PrescriptionDto;
import src.main.java.com.jadevirek.prescriptionapp.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

@RestController
public class PrescriptionRestController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionRestController(
            PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    /**
     * This method return all Prescriptions
     *
     * @return
     */
    @GetMapping("/prescription")
    @CrossOrigin
    public List<PrescriptionDto> findAll() {
        return prescriptionService.findAll();
    }

    @GetMapping(value = "/prescription/{id}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable long id) {
        Optional<PrescriptionDto> byId = prescriptionService.findById(id);
        System.out.println(byId);
        return prescriptionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException("No entity found, with given id"));
    }

    @DeleteMapping("/prescription/{id}")
    @CrossOrigin
    public ResponseEntity<?> deletePrescription(@PathVariable Long id) {
        return prescriptionService.deletePrescription(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException("Deletion failed- no entity found."));
    }

    /**
     * Add new prescription
     *
     * @param prescriptionDto
     * @return
     */
    @PostMapping("/prescription")
    @CrossOrigin
    public ResponseEntity<?> createPrescription(@RequestBody PrescriptionDto prescriptionDto) {
        try {
            prescriptionService.addPrescription(prescriptionDto);
            return ResponseEntity.ok(prescriptionDto);
        } catch (Exception ex) {
            throw new CreateEntityException(ex, ex.getMessage());
        }
    }

    /**
     * Update prescription in database
     *
     * @param id
     * @param prescription
     * @return
     */
    @PutMapping(value = "/prescription/{id}")
    public ResponseEntity<?> updateById(@PathVariable(value = "id") long id,
            @RequestBody PrescriptionDto prescription) {
        try {
            prescriptionService.updatePrescriptionById(id, prescription);
            return ResponseEntity.ok(prescription);
        } catch (Exception e) {
            return ResponseEntity.notFound()
                    .build();
        }
    }
}
