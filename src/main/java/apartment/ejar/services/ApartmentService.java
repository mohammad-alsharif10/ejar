package apartment.ejar.services;

import apartment.ejar.entities.Image;
import apartment.ejar.feign.ApartmentFeign;
import apartment.ejar.feign.ImageFeign;
import apartment.ejar.models.ApartmentModel;
import apartment.ejar.util.Constants;
import apartment.ejar.util.Uploads;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ApartmentService {

    private Uploads uploads;
    private ApartmentFeign apartmentFeign;
    private ImageFeign imageFeign;


    public void uploadApartmentImages(MultipartFile[] images, Integer apartmentId) throws IOException {
        ApartmentModel apartmentModel = apartmentFeign.getApartmentById(Constants.jwt, apartmentId).getContent();
        for (MultipartFile image : images) {
            String imagePath = uploads.uploadApartmentImages
                    (image, apartmentModel.getCreatedBy());
            Image savedImage = new Image();
            savedImage.setApartmentId(apartmentId);
            savedImage.setPath(imagePath);
            imageFeign.insert(Constants.jwt, savedImage);
        }
    }
}
