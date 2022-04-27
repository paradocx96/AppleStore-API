package com.sliit.domain;

import java.util.List;

public interface ItemDataAdapter {

    public String create(Item item);

    public List<Item> getAll();

    public Item getById(String id);

    public List<Item> getByType(String type);

    public String updateById(Item item);

    public String deleteById(String id);
}
