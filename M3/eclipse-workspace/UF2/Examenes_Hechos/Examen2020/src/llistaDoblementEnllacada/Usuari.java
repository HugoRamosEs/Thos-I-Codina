package llistaDoblementEnllacada;

import java.time.LocalDate;

public class Usuari  {
	private int 	id;
	private String 	name;
	private String  email;
	private String  mobile;
	private String  password;
	private String  role;
	private String  status;
	private LocalDate  last_update;
	
	public Usuari(String name, String email, String password) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.role="RESTRICTED";
		this.status="PENDING";
		this.last_update=LocalDate.now(); 		
	}

    public String getName() {				return this.name; 		}
	public String getEmail() {				return this.email;		}
    public String getMobile() { 			return this.mobile;		}
    public String getPassword() {			return this.password;	}
    public String getRole() {				return this.role;		}
    public String getStatus() {				return this.status;		}
    public LocalDate getLast_update() {		return this.last_update;}
    public int getId() {					return this.id;			}

	public void setId(int id) {				this.id = id;			}
	public void setName(String name) {		this.name = name;		}
	public void setEmail(String email) {	this.email = email;		}
	public void setMobile(String mobile) {	this.mobile = mobile;	}
	public void setPassword(String password) {this.password = password;}
	public void setRole(String role) {		this.role = role;		}
	public void setStatus(String status) {	this.status = status;	}

	@Override
	public String toString() {
		return "Usuari [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", role=" + role + ", status=" + status + ", last_update=" + last_update + "]";
	}

}
