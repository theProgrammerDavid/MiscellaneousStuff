package com.example.opengltest1;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.DisplayMetrics;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Circle {
    private final String vertexShaderCode =
            "attribute vec4 vPosition; " +
                    "void main(){"+
                    "gl_Position = vPosition;"+
            "}";
    private final String fragmentShaderCode =
            "precision mediump float;"+
                    "uniform vec4 vColor;"+
                    "void main(){" +
                    "gl_FragColor = vColor;" +
                    "}";
    private FloatBuffer vertexBuffer;
    private static final int COORDS_PER_VERTEX = 3;
    private final int vertexStride = COORDS_PER_VERTEX * 4;
    private int app = -1;



    /**
     *
     * @param cx
     * @param cy
     * @param radius
     * @param segments
     */
    public Circle(float cx, float cy, float radius, int segments){
        calPoints(cx,cy,radius,segments);
        if(app==-1){
            int vertexShader = OpenGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
            int fragShader = OpenGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

            app = GLES20.glCreateProgram();

            GLES20.glAttachShader(app, vertexShader);
            GLES20.glAttachShader(app, fragShader);
            GLES20.glLinkProgram(app);

        }
    }

    /**
     *
     * @param cx
     * @param cy
     * @param radius
     * @param segments
     */
    public void calPoints(float cx, float cy, float radius, int segments){
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();

        float[] coordinates = new float[segments * COORDS_PER_VERTEX];

        for (int i = 0; i < segments * COORDS_PER_VERTEX; i += COORDS_PER_VERTEX) {
            float percent = (i / (segments - 1f));
            float rad = percent * 2f * (float) Math.PI;

            //Vertex position
            float xi = cx + radius * (float) Math.cos(rad);
            float yi = cy + radius * (float) Math.sin(rad);

            coordinates[i] = xi;
            coordinates[i + 1] = yi / (((float) dm.heightPixels / (float) dm.widthPixels));
            coordinates[i + 2] = 0.0f;
        }

        ByteBuffer  bb = ByteBuffer.allocateDirect(coordinates.length * 4);
        bb.order(ByteOrder.nativeOrder());

        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.put(coordinates);
        vertexBuffer.position(0);
    }

    /**
     * OpenGL draw function
     */
    public void draw(){
       int vertexCount = vertexBuffer.remaining() / COORDS_PER_VERTEX;
       GLES20.glUseProgram(app);

       int mPositionHandle = GLES20.glGetAttribLocation(app, "vPosition");
       GLES20.glEnableVertexAttribArray(mPositionHandle);

       GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false,
               vertexStride, vertexBuffer);

       int mColorHandle = GLES20.glGetUniformLocation(app, "vColor");
       GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, vertexCount);
       GLES20.glDisableVertexAttribArray(mPositionHandle);
       GLES20.glUniform4fv(mColorHandle, 1, new float[]{0.5f, 0.3f, 0.1f, 1f}, 0);

    }
}
