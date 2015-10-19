/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opengl.demo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.glfwInit;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

/**
 *
 * @author kmhasan
 */
public class OpenGLDemo {

    long window;

    public void init() {
        GLFW.glfwInit();
        window = GLFW.glfwCreateWindow(800, 800, "LWJGL Demo", 0, 0);
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
    }

    public void drawGrid() {
        glBegin(GL_LINES);
            glColor3f(1.0f, 0.0f, 0.0f);
            glVertex3f(-1.0f, 0.0f, 0.0f);
            glVertex3f(+1.0f, 0.0f, 0.0f);
            glColor3f(0.0f, 1.0f, 0.0f);
            glVertex3f(0.0f, -1.0f, 0.0f);
            glVertex3f(0.0f, +1.0f, 0.0f);
            glColor3f(1.0f, 1.0f, 1.0f);
            glVertex3f(0.5f, -1.0f, 0.0f);
            glVertex3f(0.5f, +1.0f, 0.0f);
            glColor3f(0.75f, 0.75f, 0.75f);
            glVertex3f(0.25f, -1.0f, 0.0f);
            glVertex3f(0.25f, +1.0f, 0.0f);
        glEnd();
    }

    public void loop() {
        GL.createCapabilities();
        glClearColor(0f, 0f, 0f, 1f);
        while (GLFW.glfwWindowShouldClose(window) == GL_FALSE) {
            glClear(GL_COLOR_BUFFER_BIT);
            
            drawGrid();
            glBegin(GL_TRIANGLES);
                glVertex3f(-0.5f, -0.5f, 0.0f);
                glVertex3f(+0.5f, -0.5f, 0.0f);
                glVertex3f(+0.0f, +0.5f, 0.0f);
            glEnd();
            
            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    public OpenGLDemo() {
        init();
        loop();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new OpenGLDemo();
    }

}
