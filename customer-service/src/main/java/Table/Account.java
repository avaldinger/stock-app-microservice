package Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "owner_type")
	private String ownerType;


	@OneToMany(mappedBy = "accounts", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<AccountBalances> accountBalances;


	public Account() {
	}

	public Account(String firstName, String lastName, String ownerType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ownerType = ownerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	@Override
	public String toString() {
		return "Accounts id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", ownerType=" + ownerType;
	}

	public List<AccountBalances> getAccountBalances() {
		return accountBalances;
	}

	public void setAccountBalances(List<AccountBalances> accountBalances) {
		this.accountBalances = accountBalances;
	}



	// convenience method to add portfolios
	public void addAccountBalance(AccountBalances tempAccountBalance) {

		if (accountBalances == null) {
			accountBalances = new ArrayList<>();
		}

		accountBalances.add(tempAccountBalance);

		tempAccountBalance.setAccounts(this);
	}

}
