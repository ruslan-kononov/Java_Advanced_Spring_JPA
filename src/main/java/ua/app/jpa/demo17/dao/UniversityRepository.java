package ua.app.jpa.demo17.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.app.jpa.demo17.domain.AccreditationLevel;
import ua.app.jpa.demo17.domain.University;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {

    University findByName(String name);

    List<University> findByNumberStudentsGreaterThanEqual(int number);

    List<University> findByNumberInstitutesGreaterThanEqual(int number);

    List<University> findAllByAcrLevel(AccreditationLevel accreditationLevel);

}
