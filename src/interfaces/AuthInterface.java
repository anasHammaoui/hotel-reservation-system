package src.interfaces;
public interface AuthInterface {
    String register(String fullName, String email, String password);
    String login(String email, String password);
    boolean isLogedIn();
}
