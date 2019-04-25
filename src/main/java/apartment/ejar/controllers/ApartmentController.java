package apartment.ejar.controllers;


import apartment.ejar.entities.Apartment;
import apartment.ejar.feign.ApartmentFeign;
import apartment.ejar.models.Paging;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    private ApartmentFeign apartmentFeign;

    public ApartmentController(ApartmentFeign apartmentFeign) {
        this.apartmentFeign = apartmentFeign;
    }

    @RequestMapping(path = "/all", produces = "application/hal+json", method = RequestMethod.GET)
    public Paging apartments(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new Paging<>(new ArrayList<>(apartmentFeign.getApartments(page, size).getContent()),
                apartmentFeign.getPage(page, size).getContent().getPage());
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST, produces = "application/json")
    public Apartment save(@RequestBody Apartment apartment) {
        return apartmentFeign.insert(apartment);
    }
}
