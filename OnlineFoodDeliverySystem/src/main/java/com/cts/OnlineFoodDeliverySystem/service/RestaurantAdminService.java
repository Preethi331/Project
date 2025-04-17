package com.cts.OnlineFoodDeliverySystem.service;

import java.util.Optional;

import com.cts.OnlineFoodDeliverySystem.model.RestaurantAdmin;

public interface RestaurantAdminService {

	void registerAdmin(RestaurantAdmin admin);
    Optional<RestaurantAdmin> findAdminByEmail(String email);
}
