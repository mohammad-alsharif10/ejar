package apartment.ejar.feign;


import apartment.ejar.entities.Apartment;
import apartment.ejar.models.ApartmentModel;
import apartment.ejar.models.PageAndSize;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "apartment-services", url = "http://localhost:8080/apartments")
public interface ApartmentFeign {


    @RequestMapping(method = RequestMethod.POST, path = "/")
    Apartment insert(@RequestBody Apartment apartment);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resource<PageAndSize> getPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resources<ApartmentModel> getApartments(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Resource<ApartmentModel> getLocationById(@PathVariable("id") Long id);
}
