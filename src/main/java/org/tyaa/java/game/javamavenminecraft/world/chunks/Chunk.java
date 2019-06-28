/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.world.chunks;

import org.tyaa.java.game.javamavenminecraft.world.Block;

/**
 *
 * @author yurii
 */
public class Chunk {
    
    private Byte[] blocks;
    private ChunkModel model;
    private Boolean changed;
    
    public Chunk(){
        
        blocks = new Byte[16 * 256 * 16];
        model = new ChunkModel();
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
        changed = true;
    }
    
    public void setBlock(Integer i, Block block){
    
        blocks[i] = block.getId();
        changed = true;
    }

    public ChunkModel getModel() {
        return model;
    }
    
    public void updateModel() {

        /*for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 256; j++) {
                for (int k = 0; k < 16; k++) {*/
                    model.vertex(-1f, 0f, 0f);
                    model.vertex(0f, 1f, 0f);
                    model.vertex(1f, 0f, 0f);
                /*}
            }
        }*/
        
        model.create();
    }
}
