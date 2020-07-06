package ua.app.jpa.demo17.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.app.jpa.demo17.dao.UniversityRepository;
import ua.app.jpa.demo17.domain.AccreditationLevel;
import ua.app.jpa.demo17.domain.University;
import ua.app.jpa.demo17.service.UniversityService;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public void save(University university) {
        universityRepository.saveAndFlush(university);
    }

    @Override
    public University findById(Integer id) {
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public University findByName(String name){
        return universityRepository.findByName(name);
    }

    public List<University> findByNumberInstitutesGreaterThanEqual(int number){
        return universityRepository.findByNumberInstitutesGreaterThanEqual(number);
    }

    @Override
    public List<University> findAllByAccrLevel(AccreditationLevel accreditationLevel) {
        return universityRepository.findAllByAcrLevel(accreditationLevel);
    }

    public List<University> findByNumberStudentsGreaterThanEqual(int number){
        return universityRepository.findByNumberStudentsGreaterThanEqual(number);
    }

    @Override
    public University updateName(Integer id, String name) {
        University university = universityRepository.findById(id).orElse(null);
        if(university.equals(null)){
            System.out.println("There is no university with such an id");
        }else{
            university.setName(name);
            universityRepository.saveAndFlush(university);
        }
        return university;
    }

    @Override
    public University updateNumberStudents(Integer id, int number) {
        University university = universityRepository.findById(id).orElse(null);
        if(university.equals(null)){
            System.out.println("There is no university with such an id");
        }else{
            university.setNumberStudents(number);
            universityRepository.saveAndFlush(university);
        }
        return university;
    }

    @Override
    public University updateNumberInstitutions(Integer id, int number) {
        University university = universityRepository.findById(id).orElse(null);
        if(university.equals(null)){
            System.out.println("There is no university with such an id");
        }else{
            university.setNumberInstitutes(number);
            universityRepository.save(university);
        }
        return university;
    }

    @Override
    public University updateAccrLevel(Integer id, AccreditationLevel accrLevel) {
        University university = universityRepository.findById(id).orElse(null);
        if(university.equals(null)){
            System.out.println("There is no university with such an id");
        }else{
            university.setAcrLevel(accrLevel);
            universityRepository.saveAndFlush(university);
        }
        return university;
    }

    @Override
    public University updateAddress(Integer id, String address) {
        University university = universityRepository.findById(id).orElse(null);
        if(university.equals(null)){
            System.out.println("There is no university with such an id");
        }else{
            university.setAddress(address);
            universityRepository.saveAndFlush(university);
        }
        return university;
    }


    @Override
    public void deleteById(Integer id) {
        universityRepository.deleteById(id);
    }
}
