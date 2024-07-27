package pl.coderslab.szamadlaleniwych.domain;


import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class FoodIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstIngredient;

    @NotNull
    private String secondIngredient;

    @NotNull
    private String thirdIngredient;

    @ManyToOne()
    @JoinColumn()
    private User user;

    public @NotNull String getFirstIngredient() {
        return firstIngredient;
    }

    public void setFirstIngredient(@NotNull String firstIngredient) {
        this.firstIngredient = firstIngredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getSecondIngredient() {
        return secondIngredient;
    }

    public void setSecondIngredient(@NotNull String secondIngredient) {
        this.secondIngredient = secondIngredient;
    }

    public @NotNull String getThirdIngredient() {
        return thirdIngredient;
    }

    public void setThirdIngredient(@NotNull String thirdIngredient) {
        this.thirdIngredient = thirdIngredient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
