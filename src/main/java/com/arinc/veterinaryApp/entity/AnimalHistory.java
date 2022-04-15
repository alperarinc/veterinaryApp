package com.arinc.veterinaryApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;



@Entity
@Table(name = "animals_histroy")
@Data//Otomatik olarak Getter Setter yaratıyor.
@EqualsAndHashCode
@NoArgsConstructor//Boş bir constructor olmasına gerek olmuyor. Burada yapılıyor
@AllArgsConstructor//Field yapmamıza gerek kalmıyor.Burada yapılıyor
@ToString
public class AnimalHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "type",length = 50)
    private String type;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private GenderStatus gender;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "description",length = 400)
    private String description;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;

}
