/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.product;

/**
 *
 * @author Felipe Brasil
 */
public class Product {
    private int id;
    private String name;
    private int buyPrice;
    private int percetage;
    private int weight;

    /**
     * 
     * @param id
     * @param name
     * @param buyPrice pesos Colombianos
     * @param percetage values in 0-100
     * @param weight in grams
     */
    public Product(int id, String name, int buyPrice, int percetage, int weight) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.percetage = percetage;
        this.weight = weight;
    }

    public Product(){
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the buyPrice
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice the buyPrice to set
     */
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * @return the percetage
     */
    public int getPercetage() {
        return percetage;
    }

    /**
     * @param percetage the percetage to set
     */
    public void setPercetage(int percetage) {
        this.percetage = percetage;
    }
    
}
