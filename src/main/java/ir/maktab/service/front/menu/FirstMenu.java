package ir.maktab.service.front.menu;

import ir.maktab.service.front.input.InputString;
import ir.maktab.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu() {
        super(new ArrayList<>(Arrays.asList("User Log In", "Airline Panel Login", "Exit")));
    }

    @Override
    public Void runMenu(){
        while (true) {
            switch (getItemFromConsole()) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    airlinePanelLogin();
                    break;
                case 3:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }

    private void userLogin() {
        String username = getUsername();
        String password = getPassword();
        try {
            new UserMenu(ApplicationContext.getUserService().login(username, password)).runMenu();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void airlinePanelLogin() {
        String username = getUsername();
        String password = getPassword();
        try {
            new AirlineMenu(ApplicationContext.getAirlineService().login(username, password)).runMenu();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private String getPassword() {
        return new InputString("Enter your password: ").getStringInput();
    }

    private String getUsername() {
        return new InputString("Enter your username: ").getStringInput();
    }

}
