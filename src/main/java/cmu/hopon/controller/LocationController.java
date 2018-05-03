package cmu.hopon.controller;

import cmu.hopon.domain.Location;
import cmu.hopon.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(path = "/location/list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    Iterable<Location> list(@RequestParam String token) {
        return locationService.getLocations(token);
    }

    @RequestMapping(value = "/location", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Location logoutUser (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return locationService.getLocation(name);
    }

    @RequestMapping(value = "/locationId", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Location getById (@RequestParam int id, @RequestParam String token) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return locationService.getLocationById(id, token);
    }

}
