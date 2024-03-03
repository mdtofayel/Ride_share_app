package com.happyride.rideshare.Services;


import com.happyride.rideshare.Repository.StatesRepository;
import com.happyride.rideshare.model.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatesService {

    @Autowired
    private StatesRepository statesRepository;


    public List<States> listOfAllStates() {
        return statesRepository.findAll();
    }


    public States findStatesByStates(Integer id) {
        return statesRepository.findByStatesId(id);
    }


    public States saveStates(States states) {
        return statesRepository.save(states);
    }


    public void deleteStates(Integer id) {

    }


    public States findStatesByName(String statesName, int countryId) {
        return statesRepository.findByStatesName(statesName, countryId);
    }


    public States findByName(String name){
        return statesRepository.findByStatesName(name);
    }
}
