package br.group.backendmarmitas.entities.dto;

import br.group.backendmarmitas.entities.Produto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Random;

public class ProdutoDTO {



    private Long id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Integer rating;

    public ProdutoDTO(){}

    public ProdutoDTO(Long id, String name, String description, String image, Double price, Integer rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.rating = rating;
    }

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.price = entity.getPrice();
        this.rating = entity.getRating() != null ? entity.getRating() : new Random().nextInt(5) + 1;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
