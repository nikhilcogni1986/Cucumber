package awesomecucumber.customtype;

import awesomecucumber.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomeParameterType
{
    @ParameterType(".*")
    public Product product(String name)
    {
        return new Product(name.replace("\"",""));
    }
}
