package com.example.springjpaadvance.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne
    private User user;
        // Esta es la sintaxis para establecer una relacion one-to-one, en este caso establecemos que
        // un Cliente solo puedo tener 1 User asociado y visceverza

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Address> addresses = new HashSet<>();
        // Esta es la sintaxis para establecer una relacion one-to-many, en este caso establecemos que
        // 1 Client puede tener varias Address asociadas y visceverza.

        // Podemos pasar parametros a la etiqueta @OneToMany
        // -fetch: establece si queremos que al hacer la consulta de un Client esta devuelba tambien las
        //      addresses asociadas al mismo y tambien si seran de carga EAGER o LAZY
        // -cscade: establece lo que ocurre cuando se modifica un Client, en este caso ALL indica que si
        //      se modifica alguna address del Client, esta tambien se modifica en la entidad Address

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_product",
            joinColumns = {
                    @JoinColumn(name = "fk_client")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product")
            }
    )
    private Set<Product> products = new HashSet<>();
}
