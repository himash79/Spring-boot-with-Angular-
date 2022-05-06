package lk.himash.pms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_master")
public class ItemMaster {

    @Id
    @Column(name = "Item_ID")
    private String itemId;

    @Column(name = "Item_Name")
    private String item_name;

    @Column(name = "Item_Category")
    private String item_category;

    @Column(name = "Item_Price")
    private String item_price;

    @Column(name = "Item_Status")
    private String item_status;
}
