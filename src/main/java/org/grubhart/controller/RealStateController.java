package org.grubhart.controller;


import org.grubhart.domain.RealStateResultItem;
import org.grubhart.service.RealStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealStateController {

    @Autowired
    RealStateService realStateService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/search")
    public RealStateResultItem[] search(@RequestParam(value="address") String address, @RequestParam(value = "specialOffer") String specialOffer) {
        return realStateService.searchArray(address,specialOffer);

    }
}
