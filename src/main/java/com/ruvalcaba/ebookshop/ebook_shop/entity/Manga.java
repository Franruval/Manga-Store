package com.ruvalcaba.ebookshop.ebook_shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name="mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String publisher;
    private String volume;
    private String price;

    public Manga(){
    }

    public Manga(Long id, String title, String publisher, String price, String volume) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
