package apartment.ejar.controllers;


import apartment.ejar.entities.Image;
import apartment.ejar.feign.ImageFeign;
import apartment.ejar.models.Paging;
import apartment.ejar.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageFeign imageFeign;
    private Constants constants;

    @RequestMapping(path = "/all", produces = "application/hal+json", method = RequestMethod.GET)
    public Paging images(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return new Paging<>(new ArrayList<>(imageFeign.getImages(constants.jwt, page, size).getContent()),
                imageFeign.getPage(constants.jwt, page, size).getContent().getPage());
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST, produces = "application/json")
    public Image save(@RequestBody Image image) {
        return imageFeign.insert(constants.jwt, image);
    }
}
