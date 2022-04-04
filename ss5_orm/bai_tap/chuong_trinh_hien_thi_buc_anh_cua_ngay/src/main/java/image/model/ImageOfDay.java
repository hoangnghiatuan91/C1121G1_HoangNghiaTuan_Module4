package image.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ImageOfDay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short rating;
    private String message;
    private String author;
    private Integer likeTotal;

    public ImageOfDay() {
    }

    public ImageOfDay(Short rating, String message, String author) {
        this.rating = rating;
        this.message = message;
        this.author = author;
    }

    public ImageOfDay(Short rating, String message, String author, Integer likeTotal) {
        this.rating = rating;
        this.message = message;
        this.author = author;
        this.likeTotal = likeTotal;
    }

    public ImageOfDay(Long id, Short rating, String message, String author, Integer likeTotal) {
        this.id = id;
        this.rating = rating;
        this.message = message;
        this.author = author;
        this.likeTotal = likeTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLikeTotal() {
        return likeTotal;
    }

    public void setLikeTotal(Integer likeTotal) {
        this.likeTotal = likeTotal;
    }
}
