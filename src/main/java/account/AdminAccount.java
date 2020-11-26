package account;

public class AdminAccount extends Account implements FacadeAdminAccount {


    public AdminAccount(String name, String surname, String login, String password, int userID) {
        super(name, surname, login, password, userID);
    }

    public void changeUserStatus(CustomerAccount account, UserState newState){
        account.userState = newState;
    }

    @Override
    public void accountLoop() { //todo

    }
}