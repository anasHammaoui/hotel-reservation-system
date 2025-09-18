package src.interfaces;

import java.util.UUID;

import src.models.User;

public interface AuthInterface {
    String register(String fullName, String email, String password);
    String login(String email, String password);
    boolean isLogedIn();
    UUID getId();
    User getAuthUser(boolean isLogedIn, UUID id);
}
