package com.task;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryS ser;


    /**
     * by getting this "GET" http request - give all the inventories info.
     * @return list of inventories.
     */

    @GetMapping("/inventories")
    @ApiOperation(value = "Get all inventories",notes ="provides a list of all inventories from DB")
    public List<Inventory> getAll(){
        return ser.getAll();
    }


    /**
     * by getting http request with number -> search for the inventory with this num.
     * @param number - the inventory number we search for
     * @return - the inventory
     */

    @GetMapping("/inventories/{number}")
    @ApiOperation(value = "Get a specific inventory ",notes ="provide a number to look for the spesific inventory")
    public Inventory getByNumber(@PathVariable int number){ //take the variable from path
        Inventory curr =  ser.getByNum(number);
        if(curr == null){
            System.out.println("not exsiting");
            return null;
        }
        else return curr;
    }


    @PostMapping(value = "/inventories/add")
    @ApiOperation(value = "Add an Inventory ",notes ="provide an inventory details to add an inventory to DB")
    public ResponseEntity addInventory(@RequestBody Inventory in){
        return this.ser.addIn(in);

    }

    @PutMapping("/inventories/{number}")
    @ApiOperation(value = "Update an inventory details",notes ="provide a number of a specific inventory you want to update")
    public void updateInventory(@RequestBody Inventory in , @PathVariable int number){
      this.ser.update(in,number);
    }

    @PutMapping("/inventories/{number}/{amount}")
    @ApiOperation(value = "Update an inventory amount",notes ="provide a number of a specific inventory you want to update, and the new amount")
    public void updateInventoryAmount(@PathVariable int number,@PathVariable int amount){
        this.ser.updateInventoryAmount(number,amount);
    }

    @DeleteMapping("/inventories/{number}")
    @ApiOperation(value = "Delete an Inventory ",notes ="provide a number in order to delete the specific inventory")
    public @ResponseBody String deleteInventory(@PathVariable int number){
      if(this.ser.remove(number) == 1)
          return "Deletion completed successfully";
      return "The deletion cannot be performed because no such number exists";
    }

}
