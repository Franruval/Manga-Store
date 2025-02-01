package com.ruvalcaba.ebookshop.ebook_shop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class MyMangas {

    @Id
    private Long id;
    private String title;
    private String publisher;
    private String volume;
    private String price;

    public MyMangas(Long id, String title, String publisher, String volume, String price) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.volume = volume;
        this.price = price;
    }

    public MyMangas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
