package com.bvr;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByName(String name) ;
	
	
	//@Query("select u from PatientTable as u where u.patientId = :patientId")
	//List<Patient> findByPatientId(String patientId) ;
	

}
