package src.services;

import java.util.ArrayList;

import src.models.User;

public class AuthService {
    public boolean register(ArrayList<User> users, String fullName, String email, String password){
        for (User user: users){
            if (user.getEmail().equalsIgnoreCase(email)){
                return false;
            }     
        }
        User user = new User(fullName, email, password);
        users.add(user);
        return true;
    }
}
