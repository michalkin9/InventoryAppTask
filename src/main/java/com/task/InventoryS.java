package com.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        //return list of all inventories in the DB;
        List<Inventory> inventories = new ArrayList<>();
         inventoryRep.findAll().forEach(inventories::add);
         return inventories;
    }

    //find the first element with the number er look for.
    public Inventory getByNum(int num){
      return inventoryRep.findById(num).orElse(null);
    }

    public ResponseEntity addIn(Inventory in){
        if(in.getNumber() == 0)
            return new ResponseEntity(
                    "Can't be preformed. number should be greater then zero",
                    HttpStatus.BAD_REQUEST);
        else if(inventoryRep.existsById(in.getNumber()))
            return new ResponseEntity(
                    "Ths ID is already exists",
                    HttpStatus.BAD_REQUEST);
        inventoryRep.save(in); //saves object in the DB.
        return new ResponseEntity(
                "Successfully added to database",
                HttpStatus.OK);
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

    public void updateInventoryAmount(int number, int amount) {

        Inventory v=  inventoryRep.findById(number).orElse(null);
        if(v == null) return;
        else{
            if(amount<0)
                return;
            else v.setAmount(amount);
        }
        inventoryRep.save(v);
    }

    public int remove(int number){

        // if number exsits then delete
        if (inventoryRep.existsById(number)) {
            inventoryRep.deleteById(number);
            return 1;
        }

        return -1;

    }


}
