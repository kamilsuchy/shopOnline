package offers;

import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Offers {
    List<Product> productList;
    public static Offers instance;

    private Offers(){
        instance = this;
        productList = new ArrayList<>();
    }

    public static Offers getInstance(){
        if (instance == null){
            instance = new Offers();
        }
        return instance;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product a){
        productList.add(a);
    }
}
