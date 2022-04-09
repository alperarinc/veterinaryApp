package com.arinc.vetenaryApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data//Otomatik olarak Getter Setter yaratıyor.
@EqualsAndHashCode
@NoArgsConstructor//Boş bir constructor olmasına gerek olmuyor. Burada yapılıyor
@AllArgsConstructor//Field yapmamıza gerek kalmıyor.Burada yapılıyor
@ToString
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "surname",length = 50)
    private String surname;
    @Column(name = "tel_number",length = 10,unique = true)
    private String telNumber;
    @Column(name = "adress",length = 200)
    private String address;
    @Column(name = "email",length = 50,unique = true)
    private String email;
}