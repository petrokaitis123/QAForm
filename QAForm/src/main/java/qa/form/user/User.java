package qa.form.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import qa.form.employeeRecords.EmployeeRecord;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String password;
	private Boolean isAdmin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeRecord_id")
	private EmployeeRecord employeeRecord;
	
	public User() {}
	
	public User(Long id, String password, Boolean isAdmin, EmployeeRecord employeeRecord) {
		super();
		this.id = id;
		this.password = password;
		this.isAdmin = isAdmin;
		this.employeeRecord = employeeRecord;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Boolean getIsAdmin() {
		return isAdmin;
	}



	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	public EmployeeRecord getEmployeeRecord() {
		return employeeRecord;
	}



	public void setEmployeeRecord(EmployeeRecord employeeRecord) {
		this.employeeRecord = employeeRecord;
	}



	

	
	
}
