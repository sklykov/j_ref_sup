package basic_lang_features;

public class Child extends Parent{
    int id;
    private String description = "This is child class";
    private String anotherSpecificValue = "Specific for Child class";

    Child(){
        super();
        id = super.id + 1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getAnotherSpecificValue() {
        return anotherSpecificValue;
    }

}
