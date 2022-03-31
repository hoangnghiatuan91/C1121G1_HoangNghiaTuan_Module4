package to_khai_y_te.service;

import to_khai_y_te.model.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationService {
    List<MedicalDeclaration> findAll();

    void save(MedicalDeclaration medicalDeclaration);

    MedicalDeclaration findById(int id);

    void update(int id, MedicalDeclaration medicalDeclaration);
}
