package apartment.ejar.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class Uploads {

    public String convertFile(MultipartFile file, String name) throws IOException {
        new File("E:\\courses\\Newfolder\\" + name).mkdir();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String imagePath = "E:\\courses\\Newfolder\\" + name + "\\" + "hiii" + "." + extension;
        File convertFile = new File(imagePath);
        FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return imagePath;
    }

}
