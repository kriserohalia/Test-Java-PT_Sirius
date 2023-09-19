package com.crudclassdiagram.testjavapt_sirius.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "master_mobil")
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "roda_id")
    private List<Roda> rodaList;
}
