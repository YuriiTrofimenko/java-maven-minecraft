/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.rendering;

import org.lwjgl.opengl.GL30;
import org.tyaa.java.game.javamavenminecraft.world.chunks.Chunk;

/**
 *
 * @author yurii
 */
public class ChunkRenderer {
    
    public void render(Chunk chunk){
    
        GL30.glBindVertexArray(chunk.getModel().getVao());
        GL30.glEnableVertexAttribArray(0);
        GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, chunk.getModel().getVertexCount());
        GL30.glDisableVertexAttribArray(0);
        GL30.glDrawArrays(0, 0, 0);
    }
}
