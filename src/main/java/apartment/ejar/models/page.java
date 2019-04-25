package apartment.ejar.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class page {
    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
    private Integer number;

}
