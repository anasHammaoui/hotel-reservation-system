package src.interfaces;

public interface AuthInterface {
    boolean register(String fullName, String email, String password);
    String login();
    boolean isLogedIn();
}
