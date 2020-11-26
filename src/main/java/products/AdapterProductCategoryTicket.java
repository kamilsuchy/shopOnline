package products;

public class AdapterProductCategoryTicket extends ProductCategoryTicket  implements Product {

    @Override
    public void print() {
        wyswietl();
    }
}