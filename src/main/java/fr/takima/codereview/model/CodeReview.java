package fr.takima.codereview.model;

import java.time.LocalDate;

public class CodeReview {
    private int id;
    private String name;
    private String description;
    private java.time.LocalDate datetime;
    private int id_promotion;

    public CodeReview(int id, String name, String description, LocalDate datetime, int id_promotion) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datetime = datetime;
        this.id_promotion = id_promotion;
    }

    public int getId() {
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

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    @Override
    public String toString() {
        return "CodeReview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", id_promotion=" + id_promotion +
                '}';
    }
}
