package products;

public class ProductCategoryGame implements Product{

    private String name;
    private String description;
    private String releaseDate;
    private double price;

    @Override
    public void print() {
        System.out.println("name: " + name + "\n" +
                "description: " + description + "\n" +
                "release date: " + releaseDate + "\n" +
                "price: " + price);
    }
}
