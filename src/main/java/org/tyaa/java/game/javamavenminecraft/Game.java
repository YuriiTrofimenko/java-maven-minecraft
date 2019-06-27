/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.game.javamavenminecraft;

import org.tyaa.java.game.javamavenminecraft.rendering.Window;
import org.tyaa.java.game.javamavenminecraft.world.World;
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
        // ChunkShader chunkShader = new ChunkShader();
        
        while (!window.isCloseRequested()) {    
            
            System.out.println("rendering...");
            window.update();
        }
        window.close();
    }
}
