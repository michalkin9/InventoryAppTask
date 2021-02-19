package com.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InventoryS {

    @Autowired
    private InventoryRep inventoryRep;

    public List<Inventory> getAll(){

        //return inventoryRep.;
        List<Inventory> inventories = new ArrayList<>();
         inventoryRep.findAll().forEach(inventories::add);
         return inventories;
    }

    //find the first element with the number er look for.
    public Inventory getByNum(int num){
      return inventoryRep.findById(num).orElse(null);
    }

    public String addIn(Inventory in){
        if(in.getNumber() == 0)
            return "Can't be preformed. number should be greater then zero";
        else if(inventoryRep.existsById(in.getNumber()))
            return "The id number already exsits";
        inventoryRep.save(in); //saves object in the DB.
        return "Successfully added to database";
    }

    public void update(Inventory in, int number) {
       Inventory v=  inventoryRep.findById(number).orElse(null);
       if(v == null) return;
       else{
           v.setAmount(in.getAmount());
           v.setName(in.getName());
           v.setCode(in.getCode());
       }
       inventoryRep.save(v);

    }

    public int remove(int number){

        if (inventoryRep.existsById(number)) {
            inventoryRep.deleteById(number);
            return 1;
        }

        return -1;

    }
}
