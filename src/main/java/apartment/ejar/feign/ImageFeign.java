package apartment.ejar.feign;


import apartment.ejar.entities.Image;
import apartment.ejar.models.ImageModel;
import apartment.ejar.models.PageAndSize;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "image-services", url = "http://localhost:8080/images")
public interface ImageFeign {


    @RequestMapping(method = RequestMethod.POST, path = "/")
    Image insert(@RequestBody Image image);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resource<PageAndSize> getPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Resources<ImageModel> getImages(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    Resource<ImageModel> getLocationById(@PathVariable("id") Long id);
}