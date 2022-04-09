package com.arinc.vetenaryApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "animals")
@Data//Otomatik olarak Getter Setter yaratıyor.
@EqualsAndHashCode
@NoArgsConstructor//Boş bir constructor olmasına gerek olmuyor. Burada yapılıyor
@AllArgsConstructor//Field yapmamıza gerek kalmıyor.Burada yapılıyor
@ToString
public class Animal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "species")
    private String species;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private GenderStatus gender;

    @Column(name = "name")
    private String name;

    @Column(name = "old")
    private String old;

    @Column(name = "age")
    private int age;

    @Column(name = "description",length = 400)
    private String description;

    @JoinColumn(name = "assig_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;




}
