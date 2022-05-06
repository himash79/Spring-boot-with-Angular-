package lk.himash.pms.util;

import lk.himash.pms.DTO.ItemMasterDto;
import lk.himash.pms.model.ItemMaster;

public class DtoToEntity {

    public static ItemMaster convertToEntity(ItemMasterDto itemMasDto) {
        ItemMaster itemMa = new ItemMaster();
        itemMa.setItemId(itemMasDto.getItemId());
        itemMa.setItem_name(itemMasDto.getItem_name());
        itemMa.setItem_category(itemMasDto.getItem_category());
        itemMa.setItem_price(itemMasDto.getItem_price());
        itemMa.setItem_status(itemMasDto.getItem_status());
        return itemMa;
    }

}
