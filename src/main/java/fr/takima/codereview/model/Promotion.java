package fr.takima.codereview.model;

public class Promotion {
    private int id;
    private String name;

    public Promotion(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Promotion(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
