package pl.coderslab.szamadlaleniwych.dto;


public class FoodIngredientsDto {

    private String firstIngredient;

    private String secondIngredient;

    private String thirdIngredient;

    private String effect;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getFirstIngredient() {
        return firstIngredient;
    }

    public void setFirstIngredient(String firstIngredient) {
        this.firstIngredient = firstIngredient;
    }

    public String getSecondIngredient() {
        return secondIngredient;
    }

    public void setSecondIngredient(String secondIngredient) {
        this.secondIngredient = secondIngredient;
    }

    public String getThirdIngredient() {
        return thirdIngredient;
    }

    public void setThirdIngredient(String thirdIngredient) {
        this.thirdIngredient = thirdIngredient;
    }
}
