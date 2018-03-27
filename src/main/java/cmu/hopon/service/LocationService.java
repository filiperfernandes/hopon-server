package cmu.hopon.service;

import cmu.hopon.domain.Location;
import cmu.hopon.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location addLocation(Location location) {
        locationRepository.save(location);
        return location;
    }

    public Iterable<Location> getLocations(){
        return locationRepository.findAll();
    }
}
