package com.slasher.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "adm_president")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter
public class AdmPresident {

    @Id
    @Column(name = "amd_president_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admPresidentID;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String country;
    private Integer age;

}
