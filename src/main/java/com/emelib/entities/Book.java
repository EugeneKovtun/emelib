package com.emelib.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.File;
import java.util.List;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String author;
    private File file;
    private int price;
    private List<Account> accounts;

}
