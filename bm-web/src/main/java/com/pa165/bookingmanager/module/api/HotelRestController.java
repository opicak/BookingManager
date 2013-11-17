package com.pa165.bookingmanager.module.api;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jan Hrubeš
 */

@Controller("hotelRestController")
@RequestMapping(value = "/api/hotel")
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelDto> getList() {
        return hotelService.findAll();
    }

    @RequestMapping(value = "/id/{hotelId}", method = RequestMethod.GET)
    @ResponseBody
    public HotelDto getHotel(@PathVariable(value = "hotelId") Long hotelId) {
        return hotelService.find(hotelId);
    }
}
