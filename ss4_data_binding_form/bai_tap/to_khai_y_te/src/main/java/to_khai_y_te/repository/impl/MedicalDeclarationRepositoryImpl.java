package to_khai_y_te.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import to_khai_y_te.model.MedicalDeclaration;
import to_khai_y_te.repository.MedicalDeclarationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository {
    private  static final Map<Integer, MedicalDeclaration> medicalDeclarationMap = new HashMap<>();
//    static {
//        medicalDeclarationMap = new HashMap<>();
//        medicalDeclarationMap.put(new MedicalDeclaration())
//    }

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
