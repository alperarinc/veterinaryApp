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

    @JoinColumn(name = "customer_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Customer customer;


}
