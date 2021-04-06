package src.main.java.com.jadevirek.prescriptionapp.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.jadevirek.prescriptionapp.repository.IPrescriptionRepository;

@Service
public class IMedicamentService {

    private final IPrescriptionRepository iPrescriptionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IMedicamentService(
            IPrescriptionRepository iPrescriptionRepository, ModelMapper modelMapper) {
        this.iPrescriptionRepository = iPrescriptionRepository;
        this.modelMapper = modelMapper;
    }




}
