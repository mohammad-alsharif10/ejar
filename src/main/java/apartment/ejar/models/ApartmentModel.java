package apartment.ejar.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class ApartmentModel extends Model {

    private Float area;

    private Float latitude;

    private Float longitude;

    private Integer maximumRentersNumber;

    private String address;

    private Integer monthlyRent;

    private Integer status;

    private Integer locationId;

    private Integer brokerId;

      private String createdBy;

      private Date createdOn;

}
