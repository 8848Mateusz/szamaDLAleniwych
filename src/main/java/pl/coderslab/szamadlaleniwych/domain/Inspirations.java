package pl.coderslab.szamadlaleniwych.domain;


import jakarta.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Inspirations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Inspirations() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
