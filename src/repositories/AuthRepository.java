package src.repositories;

import src.interfaces.AuthInterface;

public class AuthRepository implements AuthInterface {
    public int register(){
        return 2;
    }
    public int login(){
        return 4;
    }
    public boolean isLogedIn(){
        return false;
    }
}
