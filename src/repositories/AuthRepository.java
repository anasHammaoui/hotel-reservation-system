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
    public String register(String fullName, String email, String password){
        String message = authService.register(users, fullName, email, password);
        if ( message.equals("done")){
            for (User user: users){
                if (user.getEmail().equals(email)){
                    this.id = user.getId();
                    this.isLogedIn = true;
                    break;
                }
            }
        }
        return message;
    }
    public String login(String email, String password){
        try {
            User user = authService.login(users, email, password);
            this.id = user.getId();
            this.isLogedIn = true;
            return "done";
        } catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
    public boolean isLogedIn(){
        return this.isLogedIn;
    }
    public UUID getId(){
        return this.id;
    }
    public User getAuthUser(boolean isLogedIn, UUID id){
        if (isLogedIn) {
            for(User user:users){
                if (user.getId() == id){
                    return user;
                }
            }
        }
        return null;
    }
}
