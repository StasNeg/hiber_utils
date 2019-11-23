package com.stanisln.hibernate.hibernate_tester.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars", uniqueConstraints = {@UniqueConstraint(columnNames = {"number"}, name = "meals_unique_user_datetime_idx")})
public class Car extends AbstractBaseEntity {
    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "description", nullable = false)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "type", nullable = false)
    private String type;


}