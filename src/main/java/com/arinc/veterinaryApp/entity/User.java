package com.arinc.veterinaryApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", indexes = {@Index(name = "idx_usernama", columnList = "uname")})
@Data//Otomatik olarak Getter Setter yaratıyor.
@EqualsAndHashCode
@NoArgsConstructor//Boş bir constructor olmasına gerek olmuyor. Burada yapılıyor
@AllArgsConstructor//Field yapmamıza gerek kalmıyor.Burada yapılıyor
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "username", length = 200)
    private String username;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Animal> animals;


}
