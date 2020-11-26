import loginAndRegister.Register;

public class ShopOnline {
    private static ShopOnline instance;

    private ShopOnline() {
        instance = this;
    }

    public static ShopOnline getInstance() {
        if (instance == null) {
            instance = new ShopOnline();
        }
        return instance;
    }

    private void shopLoop() {
        Register.logOrRegister();
    }

    public static void main(String[] args) {
        ShopOnline shop = getInstance();
        shop.shopLoop();
    }
}