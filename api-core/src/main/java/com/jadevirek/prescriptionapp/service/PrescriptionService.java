package src.main.java.com.jadevirek.prescriptionapp.service;


import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import src.main.java.com.jadevirek.prescriptionapp.common.CreateEntityException;
import src.main.java.com.jadevirek.prescriptionapp.model.Prescription;
import src.main.java.com.jadevirek.prescriptionapp.model.dto.PrescriptionDto;
import src.main.java.com.jadevirek.prescriptionapp.model.dto.PrescriptionDto.PrescriptionDtoBuilder;
import src.main.java.com.jadevirek.prescriptionapp.repository.IPrescriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrescriptionService {

    private final IPrescriptionRepository iPrescriptionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PrescriptionService(
            IPrescriptionRepository iPrescriptionRepository, ModelMapper modelMapper) {
        this.iPrescriptionRepository = iPrescriptionRepository;
        this.modelMapper = modelMapper;
    }

    /**
     *
     *
     * @return
     */
    public List<PrescriptionDto> findAll() {
        return modelMapper.map(iPrescriptionRepository.findAll(),
                new TypeToken<List<PrescriptionDtoBuilder>>() {
                }.getType());
    }

    /**
     * Method returns a Prescription by id
     *
     * @param id
     * @return
     */
    public Optional<PrescriptionDto> findById(Long id) {
        Assert.notNull(id, "id can't be null");
        return iPrescriptionRepository.findById(id)
                .map(this::convertToDto);

    }

    /**
     * This method delete person by id
     *
     * @param id
     */
    public Optional<PrescriptionDto> deltePrescription(Long id) {
        Assert.notNull(id, "id can't be null");
        Optional<Prescription> prescriptionDto = iPrescriptionRepository.findById(id);
        iPrescriptionRepository.deleteById(id);
        return prescriptionDto.map(this::convertToDto);
    }

    /**
     *
     *
     * @param prescriptionDto
     * @return
     */
    public PrescriptionDto addPrescription(PrescriptionDto prescriptionDto) {
        Assert.notNull(prescriptionDto, "Object can't be null!");
        validatePrescriptionFields(prescriptionDto);
        Prescription save = iPrescriptionRepository.save(modelMapper.map(prescriptionDto, Prescription.class));
        return convertToDto(save);
    }

    private PrescriptionDto convertToDto(Prescription prescription) {
        return modelMapper.map(prescription, PrescriptionDtoBuilder.class).build();
    }

    private void validatePrescriptionFields(PrescriptionDto prescriptionDto){
       try{
           Assert.notNull(prescriptionDto.getSerialNumber(), "Prescription required serial-number! ");
           Assert.notNull(prescriptionDto.getDate(), "Prescription required date! ");
       }catch (Exception ex){
           throw new CreateEntityException(ex);
       }
    }
}
