/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.rendering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import static org.lwjgl.opengl.GL20.*;

/**
 *
 * @author yurii
 */
public class Shader {

    private Integer id;

    public Shader(String vertDir, String fragDir) {

        id = GL20.glCreateProgram();
        int vertex = loadShader("assets/shaders/" + vertDir, GL_VERTEX_SHADER);
        int fragment = loadShader("assets/shaders/" + fragDir, GL_FRAGMENT_SHADER);
        glAttachShader(id, vertex);
        glAttachShader(id, fragment);
        glLinkProgram(id);
        glValidateProgram(id);
    }

    private static int loadShader(String file, int type) {
        
        StringBuilder shaderSource = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                shaderSource.append(line).append("//\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        int shaderID = glCreateShader(type);
        glShaderSource(shaderID, shaderSource);
        glCompileShader(shaderID);
        if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.out.println(glGetShaderInfoLog(shaderID, 500));
            System.err.println("Could not compile shader!");
            System.exit(-1);
        }
        return shaderID;
    }
}
