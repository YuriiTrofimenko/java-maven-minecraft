/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft;

import org.lwjgl.opengl.GL11;
import org.tyaa.java.game.javamavenminecraft.rendering.ChunkRenderer;
import org.tyaa.java.game.javamavenminecraft.rendering.Window;
import org.tyaa.java.game.javamavenminecraft.world.World;
import org.tyaa.java.game.javamavenminecraft.world.chunks.Chunk;
// import org.tyaa.java.game.javamavenminecraft.rendering.shaders.ChunkShader;

/**
 *
 * @author yurii
 */
public class Game implements Runnable {

    private Thread gameThread;
    // 2
    private final Integer START_WIDTH, START_HEIGHT;
    
    /* public Game() {
    } */
    
    public Game(Integer width, Integer height) {
        
        this.START_WIDTH = width;
        this.START_HEIGHT = height;
    }
    
    public synchronized void start(){
        
        gameThread = new Thread(this, "game");
        gameThread.start();
    }
    
    public static void main(String[] args){
        
        // Game game = new Game();
        Game game = new Game(1280, 720);
        game.start();
    }

    @Override
    public void run() {

        // System.out.println("Hello");
        Window window =
            new Window(START_WIDTH, START_HEIGHT, "JavaMavenMinecraft");
        // 2
        World world = new World();
        Chunk chunk = new Chunk();
        chunk.updateModel();
        
        ChunkRenderer chunkRenderer = new ChunkRenderer();
        // ChunkShader chunkShader = new ChunkShader();
        
        while (!window.isCloseRequested()) {    
            
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            GL11.glClearColor(1, 0, 0, 1);
            
            chunkRenderer.render(chunk);
            // System.out.println("rendering...");
            window.update();
        }
        window.close();
    }
}
