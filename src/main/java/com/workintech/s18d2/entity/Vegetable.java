package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="vegetable", schema="fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    @NotNull(message="name can not be null")
    @Size(min=2,max=45, message=" name size must be 2 to 45")
    private String name;

    @Column(name="price")
    @DecimalMin("10")
    private double price;

    @Column(name="is_grown_on_tree")
    private boolean isGrownOnTree;
}
