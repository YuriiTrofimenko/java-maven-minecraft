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
public class Chunk {
    
    private Byte[] blocks;
    
    public Chunk(){
        
        blocks = new Byte[16 * 256 * 16];
    }
    
    public Byte getBlock(Integer x, Integer y, Integer z){
    
        // return blocks[x + y * 16 * 16 + z * 16];
        return blocks[x + y << 8 + z << 4];
    }
    
    public Byte getBlock(Integer i){
    
        return blocks[i];
    }
    
    public void setBlock(Integer x, Integer y, Integer z, Block block){
    
        blocks[x + y << 8 + z << 4] = block.getId();
    }
    
    public void setBlock(Integer i, Block block){
    
        blocks[i] = block.getId();
    }
}
