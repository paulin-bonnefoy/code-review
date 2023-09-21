package fr.takima.codereview.model;

import java.time.LocalDate;

public class CodeReview {
    private long id;
    private String name;
    private String description;
    private java.time.LocalDate datetime;
    private Promotion promotion;

    public CodeReview(long id, String name, String description, LocalDate datetime, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.promotion = promotion;
    }

    public CodeReview(String name, String description, LocalDate datetime, Promotion promotion) {
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.promotion = promotion;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "CodeReview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", id_promotion=" + promotion +
                '}';
    }
}
