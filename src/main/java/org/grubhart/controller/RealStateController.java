package org.grubhart.controller;


import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealStateController {

    @Autowired
    ResourceService resourceService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/search")
    public RealStateResultItem[] search(@RequestParam(value="address") String address, @RequestParam(value = "specialOffer") String specialOffer) {
        return resourceService.searchArray(address,specialOffer);

    }
}
