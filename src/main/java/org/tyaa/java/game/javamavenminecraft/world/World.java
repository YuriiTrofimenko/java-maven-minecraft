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
public class World {

    private final Integer MAX_LOADED_CHUNKS_WIDTH = 32;
    private Chunk[] chunks;
    
    public World() {
        chunks = new Chunk[MAX_LOADED_CHUNKS_WIDTH * MAX_LOADED_CHUNKS_WIDTH];
        for (int i = 0; i < MAX_LOADED_CHUNKS_WIDTH * MAX_LOADED_CHUNKS_WIDTH; i++) {
            chunks[i] = new Chunk();
        }
    }
    
    public Chunk getChunk(Integer x, Integer y, Integer z){
    
        // return blocks[x + y * 16 * 16 + z * 16];
        return chunks[
                x
                + y * MAX_LOADED_CHUNKS_WIDTH * MAX_LOADED_CHUNKS_WIDTH
                + z * MAX_LOADED_CHUNKS_WIDTH
            ];
    }
    
    public Chunk getChunk(Integer i){
    
        return chunks[i];
    }
}
