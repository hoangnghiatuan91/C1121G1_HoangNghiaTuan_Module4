package to_khai_y_te.service.impl;

import org.springframework.stereotype.Service;
import to_khai_y_te.model.MedicalDeclaration;
import to_khai_y_te.service.MedicalDeclarationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService {
    Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();

    @Override
    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(medicalDeclarationMap.values());
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(medicalDeclaration.getIdForm(), medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationMap.get(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(id, medicalDeclaration);
    }
}
