package lk.himash.pms.controller;

import lk.himash.pms.DTO.ItemMasterDto;
import lk.himash.pms.model.ItemMaster;
import lk.himash.pms.service.ItemMasterService;
import lk.himash.pms.util.DtoToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemMasterController {

    @Autowired
    private ItemMasterService itemMaService;

    @GetMapping("/itemAPI/getAllItems")
    public ResponseEntity<?> getAllItems() {
        return itemMaService.getAllItems();
    }

    @PostMapping("/itemAPI/saveItem")
    public ResponseEntity<?> saveItem(@RequestBody ItemMasterDto itemMaDto) {
        ItemMaster itemObject = DtoToEntity.convertToEntity(itemMaDto);
        return itemMaService.saveItem(itemObject);
    }

    @GetMapping("/itemAPI/getItem/{itemId}")
    public ResponseEntity<?> getItem(@PathVariable String itemId) {
        return itemMaService.getItem(itemId);
    }

    @DeleteMapping("/itemAPI/deleteItem/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable String itemId) {
        return itemMaService.deleteItem(itemId);
    }

    @GetMapping("/itemAPI/getAvailableItem/{paramCheck}")
    public ResponseEntity<?> getAvailableItems(@PathVariable String paramCheck) {
        return itemMaService.getAllAvailableItems(paramCheck);
    }

    @GetMapping("/itemAPI/getFilteredPriceItem/{itemPrice}")
    public ResponseEntity<?> getFilterPriceItem(@PathVariable String itemPrice) {
        return itemMaService.getFilterPriceItem(itemPrice);
    }

    @GetMapping("/itemAPI/getFilteredCategoryItem/{catType}")
    public ResponseEntity<?> getFilteredCategoryItems(@PathVariable String catType) {
        return itemMaService.getFilteredCategoryItems(catType);
    }

    @PutMapping("/itemAPI/updateItem/{itemId}")
    public ResponseEntity<?> updateItem(@RequestBody ItemMasterDto newItemDto, @PathVariable String itemId) {
        ItemMaster itemObject = DtoToEntity.convertToEntity(newItemDto);
        return itemMaService.updateItem(itemObject, itemId);
    }
}
