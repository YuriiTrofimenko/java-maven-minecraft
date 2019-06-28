/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.world.chunks;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;
import org.tyaa.java.game.javamavenminecraft.utils.Utils;

/**
 *
 * @author yurii
 */
public class ChunkModel {
    
    private List<Float> positions, uvs, colors;
    private Integer vao, vertexCount;
    
    public ChunkModel(){
        
        positions = new ArrayList<>();
        uvs = new ArrayList<>();
        colors = new ArrayList<>();
    }
    
    public void vertex(Float x, Float y, Float z){
    
        positions.add(x);
        positions.add(y);
        positions.add(z);
    }
    
    public void create(){
        
        this.vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        
        int positionsVBO = GL15.glGenBuffers();
        
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, positionsVBO);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, Utils.toArray(positions), GL15.GL_STATIC_DRAW);
        GL30.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, Utils.toArray(positions), 0);
        
        GL30.glBindVertexArray(0);
        
        this.vertexCount = positions.size() / 3;
    }

    public Integer getVao() {
        return this.vao;
    }
    
    public Integer getVertexCount() {
        return this.vertexCount;
    }
}
