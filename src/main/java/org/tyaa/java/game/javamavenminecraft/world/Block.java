/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.world;

/**
 *
 * @author yurii
 */
public class Block {
    
    private static Byte lastId = -128;
    private Byte id;
    private Integer texture;
    
    public Block(Integer texture){
        
        this.id = lastId;
        this.texture = texture;
        lastId++;
    }
    
    public Byte getId(){
        return id;
    }

    public Integer getTexture() {
        return texture;
    }
}
