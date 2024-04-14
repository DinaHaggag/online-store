package persistence.entities;

import persistence.validation.Validate;

public class DefaultUser implements User {
    private static int userCounter = 1; // static counter for user IDs

    private int id;
    @Validate(pattern="[a-zA-Z]+")
    private String firstName;
    @Validate(pattern="[a-zA-Z]+")
    private String lastName;
    @Validate(pattern=".+@\\w+[.com]")
    private String email;
    public void setId(int id) {
		this.id = id;
	}
    

    private String roleName;
	private double money;
	private String creditCard;

	private String password;

    public DefaultUser(String firstName, String lastName, String email, String password) {
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


	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public double getMoney() {
		return money;
	}


	public void setMoney(double money) {
		this.money = money;
	}


	public String getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}


	

}
