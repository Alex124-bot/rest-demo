package entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@NamedQueries({
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie"),
@NamedQuery(name = "Movie.getAll", query = "SELECT m FROM Movie m"),
@NamedQuery(name = "Movie.getByTitle", query = "SELECT m FROM Movie m WHERE m.title LIKE :title")
})

@NamedNativeQuery(name = "Movie.ResetId", query = "ALTER table Movie AUTO_INCREMENT = 1")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int year;
    private String title;
    private String[] actors;

    public Movie() {
    }

    public Movie(int year, String title, String[] actors) {
        this.year = year;
        this.title = title;
        this.actors = actors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }
}