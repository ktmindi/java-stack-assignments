package empPackage;

public class Employee {
	private String email;
	private float pay;
	public Employee(String email, float pay) {
		this.email = email;
		this.pay = pay;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	
	public void empDetails() {
		System.out.printf("\nEmail: %s, Pay: %,.2f", this.email,this.pay);
	}
	//now we need to create a constructor so you can right click on
	//line 9 and go to source and then generate constructor using fields
	
	//after we need a setter so go to source - generate getter and setter
}
