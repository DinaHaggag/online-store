package core;

public class DefaultUser implements User {
    private static int userCounter = 1; // static counter for user IDs

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.id = userCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
    

    public DefaultUser() {
		super();
	}



	@Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public static void clearState() {
        userCounter = 0; // reset user counter for testing
    }
}
