/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft.rendering;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVulkan;
import org.lwjgl.opengl.GL;

/**
 *
 * @author yurii
 */
public class Window {
    
    private Long id;
    
    public Window(Integer width, Integer height, String title){
    
        GLFW.glfwInit();
        id = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        GLFW.glfwMakeContextCurrent(id);
        GL.createCapabilities();
    }
    
    public void update(){
    
        GLFW.glfwPollEvents();
        GLFW.glfwSwapBuffers(id);
    }
    
    public void close(){
    
        GLFW.glfwTerminate();
    }
    
    public boolean isCloseRequested(){
    
        return GLFW.glfwWindowShouldClose(id);
    }
}
