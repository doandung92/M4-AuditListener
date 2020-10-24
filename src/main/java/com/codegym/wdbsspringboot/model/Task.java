package com.codegym.wdbsspringboot.model;

import com.codegym.wdbsspringboot.vm.AbstractAuditable;
import lombok.Data;

import javax.persistence.*;

@Entity
public class Task extends AbstractAuditable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private AppUser user;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
