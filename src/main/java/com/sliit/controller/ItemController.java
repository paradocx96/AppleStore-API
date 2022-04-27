package com.sliit.controller;

import com.sliit.api.ItemApi;
import com.sliit.domain.Item;
import com.sliit.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class ItemController {

    private final ItemApi itemApi;

    @Autowired
    public ItemController(ItemApi itemApi) {
        this.itemApi = itemApi;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody ItemDto itemDto) {
        Item item = new Item();

        item.setName(itemDto.getName());
        item.setCode(itemDto.getCode());
        item.setAvailableUnit(itemDto.getAvailableUnit());
        item.setPrice(itemDto.getPrice());
        item.setTaxPrice(itemDto.getTaxPrice());
        item.setProductDescription(itemDto.getProductDescription());
        item.setImagePath(itemDto.getImagePath());
        item.setType(itemDto.getType());
        item.setDatetime(LocalDateTime.now());

        return itemApi.create(item);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAll() {
        return itemApi.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item getById(@PathVariable String id) {
        return itemApi.getById(id);
    }

    @GetMapping("/byType/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getByType(@PathVariable String type) {
        return itemApi.getByType(type);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String updateById(@RequestBody ItemDto itemDto) {
        Item item = new Item();

        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setCode(itemDto.getCode());
        item.setAvailableUnit(itemDto.getAvailableUnit());
        item.setPrice(itemDto.getPrice());
        item.setTaxPrice(itemDto.getTaxPrice());
        item.setProductDescription(itemDto.getProductDescription());
        item.setImagePath(itemDto.getImagePath());
        item.setType(itemDto.getType());
        item.setDatetime(LocalDateTime.now());

        return itemApi.updateById(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable String id) {
        return itemApi.deleteById(id);
    }
}
