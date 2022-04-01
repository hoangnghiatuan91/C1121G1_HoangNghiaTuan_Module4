package to_khai_y_te.service.impl;

import org.springframework.stereotype.Service;
import to_khai_y_te.model.MedicalDeclaration;
import to_khai_y_te.repository.MedicalDeclarationRepository;
import to_khai_y_te.repository.impl.MedicalDeclarationRepositoryImpl;
import to_khai_y_te.service.MedicalDeclarationService;

import java.util.List;

@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService {
    MedicalDeclarationRepository medicalDeclarationRepository = new MedicalDeclarationRepositoryImpl();

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.save(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationRepository.findById(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update(id,medicalDeclaration);
    }
}
