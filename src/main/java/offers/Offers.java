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

    public  void removeProduct(Product p){
        productList.remove(p);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setQuantity(Product p, int q){
        for (Product product : productList){
            if (p.getName().equals(product.getName())){
                product.setQuantity(q);
            }
        }
    }

    public void addProduct(Product a){
        productList.add(a);
    }
}
