package mp1.ct;

/**
 *
 * @author Carl Tolentino
 */
public class Main {
    public static void main(String[] args){
        LogInCredentials infos = new LogInCredentials();
        LogInSc login = new LogInSc();
        login.beginApp(infos);
    }
}
