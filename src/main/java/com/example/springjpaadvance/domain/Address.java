package com.example.springjpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1,
            initialValue = 8100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "client_id")
    private Client client;
    // Esta es la sintaxis para establecer una relacion @ManyToOne la cual es complementaria a la
    // relacion @OneToMany, en este lado especificamos el tipo de carga de los datos devueltos con
    // fetch, usamos FetchType.LAZY para ver como funciona.
    // -optional: Establece que no puede existir una Address sin un Client asociado, de lo contrario
    //      serian datos corruptos
    // @JoinColumn: Establece la columna con la cual se establece la relacion entre las tablas, esto lo
    //      hace a traves del ID
    // Por ultimo solo establecemos la propiedad, en este caso solo es un objeto de tipo Client por ser
    // relacion @ManyToOne

}
