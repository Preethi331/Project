package com.cts.OnlineFoodDeliverySystem.model;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerid",length=10)
	private int customerid;
	
	@Column(name="cname",length=50,nullable = false)
	private String name;
	
	@Column(name="email",length=50,unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Column(name="phone",length=10)
	private int phone;
	
	@Column(name="address",length=10)
	private String address;

	public Customer(String name, String email, String password, int phone, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
}
