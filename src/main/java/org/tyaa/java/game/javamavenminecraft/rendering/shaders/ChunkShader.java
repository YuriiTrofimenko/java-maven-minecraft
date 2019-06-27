/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.rendering.shaders;

import org.tyaa.java.game.javamavenminecraft.rendering.Shader;

/**
 *
 * @author yurii
 */
public class ChunkShader extends Shader {
    
    public ChunkShader() {
        super("chunk.vert", "chunk.frag");
    }
    
}
