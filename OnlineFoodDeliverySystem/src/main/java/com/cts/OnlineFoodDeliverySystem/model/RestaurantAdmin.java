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
public class RestaurantAdmin {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "restaurant_name", length = 100, nullable = false)
	    private String restaurantName;

	    @Column(name = "admin_name", length = 50, nullable = false)
	    private String adminName;

	    @Column(name = "email", length = 100, unique = true, nullable = false)
	    private String email;

	    @Column(name = "password", length = 100, nullable = false)
	    private String password;

	    public RestaurantAdmin(String restaurantName, String adminName, String email, String password) {
	        this.restaurantName = restaurantName;
	        this.adminName = adminName;
	        this.email = email;
	        this.password = password;
	    }
	
	
}
