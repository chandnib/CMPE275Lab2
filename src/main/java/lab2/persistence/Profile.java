package lab2.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="profile")
@Entity
public class Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="about_me")
	private String about_me;
	
	public Profile(){
	}

	public Profile(String first_name, String last_name, String email, String address, String organization,
			String about_me) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.organization = organization;
		this.about_me = about_me;
	}

	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getOrganization() {
		return organization;
	}

	public String getAbout_me() {
		return about_me;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}
	
}