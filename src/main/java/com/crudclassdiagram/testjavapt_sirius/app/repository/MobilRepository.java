package com.crudclassdiagram.testjavapt_sirius.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudclassdiagram.testjavapt_sirius.app.model.Mobil;

public interface MobilRepository extends JpaRepository<Mobil, Long> {
}
