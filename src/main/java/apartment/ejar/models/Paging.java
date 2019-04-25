package apartment.ejar.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Paging<entity extends Model> {

    private ArrayList<entity> entities;

    private page page;
}
