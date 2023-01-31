package com.accenture.magicWand.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "magic")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magic_id")
    private Long magic_id;

    @Column(name = "magic_name")
    private String magic_name;

    @Column(name = "magic_desc")
    private String magic_desc;

    @Column(name = "magic_age_limit")
    private Integer magic_age_limit;

    @Column(name = "magic_stock")
    private Integer magic_stock;


}
