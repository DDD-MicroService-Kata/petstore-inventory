package com.ThoughtWorks.DDD.Inventory.domain.shop;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Shop {
    @Id
    private String id;
    private String name;

    public Shop() {
        this.id = UUID.randomUUID().toString();
    }

    public Shop(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
