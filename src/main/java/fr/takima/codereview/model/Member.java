package fr.takima.codereview.model;

import java.time.LocalDate;

public class Member {
    private int id;
    private String name;
    private String email;
    private java.time.LocalDate birthDate;
    private Promotion promotion;

    public Member(int id, String name, String email, LocalDate birthDate, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.promotion = promotion;
    }

    public Member(String name, String email, LocalDate birthDate, Promotion promotion) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.promotion = promotion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", promotion=" + promotion.toString() +
                '}';
    }
}
