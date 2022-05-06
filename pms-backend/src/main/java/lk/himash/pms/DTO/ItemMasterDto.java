package lk.himash.pms.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemMasterDto {

    private String itemId;
    private String item_name;
    private String item_category;
    private String item_price;
    private String item_status;

}
