package ua.app.jpa.demo17.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "accreditation")
    private AccreditationLevel acrLevel;
    @Column(name = "students_number")
    private Integer numberStudents;
    @Column(name = "institute_number")
    private Integer numberInstitutes;
    @Column(name = "address")
    private String address;

    public University() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccreditationLevel getAcrLevel() {
        return acrLevel;
    }

    public void setAcrLevel(AccreditationLevel acrLevel) {
        this.acrLevel = acrLevel;
    }

    public Integer getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(Integer studentNumber) {
        this.numberStudents = studentNumber;
    }

    public Integer getNumberInstitutes() {
        return numberInstitutes;
    }

    public void setNumberInstitutes(Integer instituteNumber) {
        this.numberInstitutes = instituteNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                acrLevel == that.acrLevel &&
                Objects.equals(numberStudents, that.numberStudents) &&
                Objects.equals(numberInstitutes, that.numberInstitutes) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, acrLevel, numberStudents, numberInstitutes, address);
    }

    @Override
    public String toString() {
        return "University ---> " +
                "id: " + id +
                ", name: " + name +
                ", accreditation level: " + acrLevel +
                ", number of students: " + numberStudents +
                ", number of institutes: " + numberInstitutes +
                ", address: " + ((address==null)?"not indicated":address) +
                ';';
    }
}
