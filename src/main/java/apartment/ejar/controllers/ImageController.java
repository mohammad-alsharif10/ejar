package apartment.ejar.controllers;


import apartment.ejar.entities.Image;
import apartment.ejar.feign.ImageFeign;
import apartment.ejar.models.Paging;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/images")
public class ImageController {

    private ImageFeign imageFeign;

    public ImageController(ImageFeign imageFeign) {
        this.imageFeign = imageFeign;
    }

    @RequestMapping(path = "/all", produces = "application/hal+json", method = RequestMethod.GET)
    public Paging images(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new Paging<>(new ArrayList<>(imageFeign.getImages(page, size).getContent()),
                imageFeign.getPage(page, size).getContent().getPage());
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST, produces = "application/json")
    public Image save(@RequestBody Image image) {
        return imageFeign.insert(image);
    }
}
