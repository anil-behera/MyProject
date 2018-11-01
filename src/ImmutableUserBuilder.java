import java.util.Date;

public class ImmutableUserBuilder {
	private final String username;
	private final String password;
	private final String firstname;
	private final String lastname;
	private final String email;
	private final Date creationDate;

	private ImmutableUserBuilder(UserBuilder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.creationDate = builder.creationDate;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.email = builder.email;
	}

	public static class UserBuilder {
		private final String username;
		private final String password;
		private final Date creationDate;
		private String firstname;
		private String lastname;
		private String email;

		public UserBuilder(String username, String password) {
			this.username = username;
			this.password = password;
			this.creationDate = new Date();
		}

		public UserBuilder firstName(String firsname) {
			this.firstname = firsname;
			return this;
		}

		public UserBuilder lastName(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ImmutableUserBuilder build() {
			return new ImmutableUserBuilder(this);
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreationDate() {
		return new Date(creationDate.getTime());
	}
}

class ImmutableTestForBuilder {

	public static void main(String[] args) {
		ImmutableUserBuilder user = new ImmutableUserBuilder.UserBuilder("shekhar", "password")
															.firstName("shekhar")
															.lastName("gulati")
															.email("shekhargulati84@gmail.com")
															.build();
	}

}
