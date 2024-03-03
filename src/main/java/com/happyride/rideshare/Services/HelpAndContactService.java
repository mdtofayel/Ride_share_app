package com.happyride.rideshare.Services;

import com.happyride.rideshare.Repository.HelpAndContactRepository;
import com.happyride.rideshare.model.HelpAndContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helpAndContactService")
public class HelpAndContactService {

    @Autowired
    private HelpAndContactRepository helpAndContactRepository;

    public HelpAndContact saveHelpAndContact(HelpAndContact helpAndContact) {
        return helpAndContactRepository.save(helpAndContact);
    }
}
