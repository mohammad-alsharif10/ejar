package apartment.ejar.models;

import lombok.Getter;
import lombok.Setter;

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

}
