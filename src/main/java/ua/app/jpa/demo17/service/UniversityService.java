package ua.app.jpa.demo17.service;

import ua.app.jpa.demo17.domain.AccreditationLevel;
import ua.app.jpa.demo17.domain.University;

import java.util.List;

public interface UniversityService {
    void save(University university);
    University findById(Integer id);
    List<University> findAll();
    List<University> findByNumberStudentsGreaterThanEqual(int number);
    List<University> findByNumberInstitutesGreaterThanEqual(int number);
    List<University> findAllByAccrLevel(AccreditationLevel accreditationLevel);
    University updateName(Integer id, String name);
    University updateNumberStudents(Integer id, int number);
    University updateNumberInstitutions(Integer id, int number);
    University updateAccrLevel(Integer id, AccreditationLevel accrLevel);
    University updateAddress(Integer id, String address);
    void deleteById(Integer id);
}
