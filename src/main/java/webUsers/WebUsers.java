package webUsers;

import account.Account;
import account.FacadeAccount;

import java.util.ArrayList;
import java.util.List;

public class WebUsers {
    List<FacadeAccount> accountList;
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

    public List<FacadeAccount> getAccountList() {
        return accountList;
    }

}
