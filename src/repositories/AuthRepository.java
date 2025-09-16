package src.repositories;

import java.util.ArrayList;
import java.util.UUID;

import src.interfaces.AuthInterface;
import src.models.User;
import src.services.AuthService;

public class AuthRepository implements AuthInterface {
    private ArrayList<User> users = new ArrayList<>();
    private UUID id;
    private AuthService authService = new AuthService();
    private boolean isLogedIn = false;
    public boolean register(String fullName, String email, String password){
        if (authService.register(users, fullName, email, password)){
            for (User user: users){
                if (user.getEmail().equals(email)){
                    this.id = user.getId();
                    this.isLogedIn = true;
                    return true;
                }
            }
        }
        return false;
    }
    public String login(){
        return "anas@gmail.com";
    }
    public boolean isLogedIn(){
        return this.isLogedIn;
    }
    public UUID getId(){
        return this.id;
    }
}
