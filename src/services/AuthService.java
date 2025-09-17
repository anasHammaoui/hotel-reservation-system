package src.services;

import java.util.ArrayList;

import src.models.User;

public class AuthService {
    public String register(ArrayList<User> users, String fullName, String email, String password){
        for (User user: users){
            if (email.isEmpty() || email.isBlank()){
                return "Please enter a valid email";
            } else if (user.getEmail().equalsIgnoreCase(email)){
                return "Account with this email Already exists";
            }     
        }
        User user = new User(fullName, email, password);
        users.add(user);
        return "done";
    }
}
