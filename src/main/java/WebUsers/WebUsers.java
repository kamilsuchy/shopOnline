package WebUsers;

import account.Account;

import java.util.ArrayList;
import java.util.List;

public class WebUsers {
    List<Account> accountList;
    public static WebUsers instance;

    private WebUsers(){
        instance = this;
        accountList = new ArrayList<>();
    }

    public static WebUsers getInstance() {
        if (instance == null){
            instance = new WebUsers();
        }
        return instance;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

}
