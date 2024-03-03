package com.happyride.rideshare.Services;


import org.springframework.stereotype.Service;

@Service
public class DriverTestService {

  /*  private DriverTestRepository driverTestRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DriverTestService(@Qualifier("driverTestRepository") DriverTestRepository driverTestRepository,
                             @Qualifier("roleRepository") RoleRepository roleRepository,
                             BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.driverTestRepository = driverTestRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public DriverTest saveDriver(DriverTest driverTest) {
       *//* driverTest.setPassword(bCryptPasswordEncoder.encode(driverTest.getPassword()));
        driverTest.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        driverTest.setRoles(new HashSet<Role>(Arrays.asList(userRole)));*//*
        return driverTestRepository.save(driverTest);
    }*/


}
