package com.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

    @Id
    @ApiModelProperty(notes = "the item's unique number")
    private int number;
    @ApiModelProperty(notes = "the item's code")
    private int code;
    @ApiModelProperty(notes = "Inventory name")
    private String name;
    @ApiModelProperty(notes = "quantity of the spesific item, can't be negative")
    private int amount;

    public Inventory(){}

    public Inventory(int number, String name,int code, int amount) {
        this.number = number;
        this.name = name;
        this.amount = (amount<0) ? 0 : amount; //if the amount is negative reset it to zero
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

//    public void setNumber(int number) {
//        this.number = number;
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
