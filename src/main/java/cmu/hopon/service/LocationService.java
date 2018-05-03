package cmu.hopon.service;

import cmu.hopon.domain.Location;
import cmu.hopon.repository.LocationRepository;
import cmu.hopon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    public Location addLocation(Location location) {
        locationRepository.save(location);
        return location;
    }

    public Iterable<Location> getLocations(String token){
        if (userRepository.findByToken(token)!=null){
            return locationRepository.findAll();
        }else{
            return null;
        }
    }

    public Location getLocation(String name){
        return locationRepository.findByName(name);
    }

    public Location getLocationById(int id, String token){
        if(userRepository.findByToken(token)!=null){
            return locationRepository.findById(id);
        }else{
            return null;
        }
    }


}
