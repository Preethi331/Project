package com.cts.OnlineFoodDeliverySystem.service;

public class RestaurantAdminServiceImpl {

	@Service
	public class RestaurantAdminServiceImpl implements RestaurantAdminService {

	    @Autowired
	    private RestaurantAdminRepository restaurantAdminRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public void registerAdmin(RestaurantAdmin admin) {
	        admin.setPassword(passwordEncoder.encode(admin.getPassword())); // Encode the password
	        restaurantAdminRepository.save(admin);
	    }

	    @Override
	    public Optional<RestaurantAdmin> findAdminByEmail(String email) {
	        return restaurantAdminRepository.findByEmail(email);
	    }
	
}
