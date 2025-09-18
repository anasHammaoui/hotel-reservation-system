package src.services;

import java.util.ArrayList;
import java.util.regex.Pattern;

import src.models.User;

public class AuthService {
    public String register(ArrayList<User> users, String fullName, String email, String password){
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        if (email.isBlank() || !Pattern.matches(emailRegex, email)){
                return "Please enter a valid email";
            }else if (password.isEmpty() || password.trim().isEmpty() || password.length() < 6){
                return "Password must be more than 6 characters";
            }
        for (User user: users){
            if (user.getEmail().equalsIgnoreCase(email)){
                return "Account with this email Already exists";
            }     
        }
        User user = new User(fullName, email, password);
        users.add(user);
        return "done";
    }
    public User login(ArrayList<User> users,String email, String password){
        for (User user: users){
                if (user.getEmail().equalsIgnoreCase(email)){
                    if (user.getPassword().equals(password)){
                        return user;
                    } else {
                        throw new IllegalArgumentException("Invalid password");
                    }
                }
            }
        throw new IllegalArgumentException("Invalid Email");
    }
}
