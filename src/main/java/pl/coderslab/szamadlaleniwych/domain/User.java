package pl.coderslab.szamadlaleniwych.domain;


import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Size(min = 6)
    private String password;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<FoodIngredients> foodIngredients;

    @OneToMany(mappedBy = "user")
    private Set<Inspirations> inspirations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="role_id")
    private Role role;

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull @Size(min = 6) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 6) String password) {
        this.password = password;
    }

    public @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotNull String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Inspirations> getInspirations() {
        return inspirations;
    }

    public void setInspirations(Set<Inspirations> inspirations) {
        this.inspirations = inspirations;
    }
}
