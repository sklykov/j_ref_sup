package basic_lang_features;

public class Parent {
    private String description = "This is parent class";
    int id = 0;
    private String specificValue = "This is specific parent class value";

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getSpecificValue() {
        return specificValue;
    }

    public void exchangeSpecificValue(){
        this.specificValue = "The specific value has been exchanged!";
    }

    final void finalExchanger(){
        this.description = "description exchanged in Parent class";
    }

}
