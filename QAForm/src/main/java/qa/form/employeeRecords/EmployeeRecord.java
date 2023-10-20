package qa.form.employeeRecords;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import qa.form.user.User;
import qa.form.inspection.Inspection;

@Entity
@Table(name="employee_records")
public class EmployeeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String occupation;
	private String address;
	private String mobileNumber;
	
	@OneToOne(mappedBy="employeeRecord")
	private User user;
	
	
	 @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JoinTable(
	    	name = "employee_inspection",
	        joinColumns = {@JoinColumn(name = "employee_record_id")},
	        inverseJoinColumns = {@JoinColumn(name = "inspection_id")})
	 
	    private Set<Inspection> inspections = new HashSet<>();
	
	public EmployeeRecord() {}

	

	public EmployeeRecord(Long id, String firstName, String lastName, String occupation, String address,
			String mobileNumber, User user, Set<Inspection> inspections) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.occupation = occupation;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.user = user;
		this.inspections = inspections;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	public String getOccupation() {
		return occupation;
	}



	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Set<Inspection> getInspections() {
		return inspections;
	}



	public void setInspections(Set<Inspection> inspections) {
		this.inspections = inspections;
	}



	

	
}
