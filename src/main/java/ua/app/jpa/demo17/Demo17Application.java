package ua.app.jpa.demo17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.app.jpa.demo17.domain.AccreditationLevel;
import ua.app.jpa.demo17.domain.University;
import ua.app.jpa.demo17.service.UniversityService;
import ua.app.jpa.demo17.service.impl.UniversityServiceImpl;

import java.util.List;

@SpringBootApplication
public class Demo17Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Demo17Application.class,args);
		UniversityService universityService = ctx.getBean(UniversityServiceImpl.class);

		University university1 = new University();
		university1.setName("Ivan Franko National University of Lviv");
		university1.setAcrLevel(AccreditationLevel.FOURTH);
		university1.setNumberInstitutes(10);
		university1.setNumberStudents(15600);

		University university2 = new University();
		university2.setName("National Universtity 'Lviv Polytechnic'");
		university2.setAcrLevel(AccreditationLevel.FOURTH);
		university2.setNumberInstitutes(8);
		university2.setNumberStudents(12400);

		University university3 = new University();
		university3.setName("National Universtity 'Kyiv Polytechnic'");
		university3.setAcrLevel(AccreditationLevel.FOURTH);
		university3.setNumberInstitutes(14);
		university3.setNumberStudents(19100);
		university3.setAddress("Kyiv");

		//save to DB
		universityService.save(university1);
		universityService.save(university2);
		universityService.save(university3);

		//read all
		universityService.findAll().forEach(System.out::println);

		//read by Id
		System.out.println("read by id:");
		System.out.println(universityService.findById(2));
		System.out.println();

		//read by number of students greater than equal
		System.out.println("read by number of students:");
		universityService.findByNumberStudentsGreaterThanEqual(13000).forEach(System.out::println);
		System.out.println();

		//read by number of institutes greater than equal
		System.out.println("read by number of institutes:");
		universityService.findByNumberInstitutesGreaterThanEqual(10).forEach(System.out::println);
		System.out.println();

		//read by accrediatation level
		System.out.println("read by accreditation level:");
		universityService.findAllByAccrLevel(AccreditationLevel.FOURTH).forEach(System.out::println);
		System.out.println();

		//update
		universityService.updateName(3,"Taras Shevchenko National University");

		//delete
		System.out.println("delete by id:");
		universityService.deleteById(2);
		System.out.println();

		//read all
		universityService.findAll().forEach(System.out::println);
	}

}
