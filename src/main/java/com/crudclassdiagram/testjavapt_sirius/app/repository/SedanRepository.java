package com.crudclassdiagram.testjavapt_sirius.app.repository;

import com.crudclassdiagram.testjavapt_sirius.app.model.Sedan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedanRepository extends JpaRepository<Sedan,Long> {
}
