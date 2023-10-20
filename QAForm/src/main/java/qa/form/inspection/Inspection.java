package qa.form.inspection;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import qa.form.defect.Defect;
import qa.form.employeeRecords.EmployeeRecord;
import qa.form.product.Product;

@Entity
@Table(name="inspections")
public class Inspection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date inspectionDate;
	private String inspector;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name="inspection_id")
	private Product product;
	
	@ManyToMany(mappedBy = "inspections")
	private Set<EmployeeRecord> employeeRecords = new HashSet<>();
	
	@OneToMany(mappedBy = "inspection")
	private List<Defect> defectsList;
	
	public Inspection() {}

	public Inspection(Long id, Date inspectionDate, String inspector, Boolean status, Product product,
			Set<EmployeeRecord> eRecords, List<Defect> defectsList) {
		super();
		this.id = id;
		this.inspectionDate = inspectionDate;
		this.inspector = inspector;
		this.status = status;
		this.product = product;
		this.employeeRecords = eRecords;
		this.defectsList = defectsList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<EmployeeRecord> geteRecords() {
		return employeeRecords;
	}

	public void seteRecords(Set<EmployeeRecord> eRecords) {
		this.employeeRecords = eRecords;
	}

	public List<Defect> getDefects() {
		return defectsList;
	}

	public void setDefects(List<Defect> defectsList) {
		this.defectsList = defectsList;
	}
	
	 


	
	
	
}
