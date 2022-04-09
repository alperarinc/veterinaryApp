package com.arinc.vetenaryApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "animal_histroy")
@Data//Otomatik olarak Getter Setter yaratıyor.
@EqualsAndHashCode
@NoArgsConstructor//Boş bir constructor olmasına gerek olmuyor. Burada yapılıyor
@AllArgsConstructor//Field yapmamıza gerek kalmıyor.Burada yapılıyor
@ToString
public class AnimalHistroy extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User assignee;

}
