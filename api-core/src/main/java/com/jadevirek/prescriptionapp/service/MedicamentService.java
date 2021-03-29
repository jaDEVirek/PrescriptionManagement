package src.main.java.com.jadevirek.prescriptionapp.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.main.java.com.jadevirek.prescriptionapp.repository.IMedicamentepository;

@Service
@Transactional
public class MedicamentService {

    private final IMedicamentepository iMedicamentepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MedicamentService(IMedicamentepository iMedicamentepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.iMedicamentepository = iMedicamentepository;
    }

}
