package apartment.ejar.controllers;


import apartment.ejar.entities.Location;
import apartment.ejar.feign.LocationFeign;
import apartment.ejar.models.Paging;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationFeign locationFeign;

    public LocationController(LocationFeign locationFeign) {
        this.locationFeign = locationFeign;
    }


    @RequestMapping(path = "/all", produces = "application/hal+json", method = RequestMethod.GET)
    public Paging locations(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new Paging<>(new ArrayList<>(locationFeign.getLocations(page, size).getContent()),
                locationFeign.getPage(page, size).getContent().getPage());
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST, produces = "application/json")
    public Location save(@RequestBody Location location) {
        return locationFeign.insert(location);
    }

    //    @Autowired
//    Uploads uploads;
//
//    @RequestMapping(value = "/newUpload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object>
//    newEntityUpload(@RequestParam(required = true, value = "image") MultipartFile file)
//            throws IOException {
//        String path = uploads.convertFile(file, "hello");
//        return new ResponseEntity<>(path, HttpStatus.OK);
//    }

}

