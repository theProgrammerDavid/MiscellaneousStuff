package com.example.opengltest1;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

public class OpenGLRenderer implements Renderer {
    private Circle circle;
    public boolean objectsReady = false;

    public Circle getCircle(){
        return circle;
    }



    /**
     * Creates, compiles and returns shader
     * @param type
     * @param shaderCode
     * @return
     */
    public static int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.9f, 0.9f,0.9f, 1f);
        circle = new Circle(0,0,0.1f, 30);
        objectsReady = true;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height){

    }

    @Override
    public void onDrawFrame(GL10 gl){
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        circle.draw();
    }
}
