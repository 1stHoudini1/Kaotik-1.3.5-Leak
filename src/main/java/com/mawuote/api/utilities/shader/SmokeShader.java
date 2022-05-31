package com.mawuote.api.utilities.shader;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import com.mawuote.api.utilities.render.*;

public class SmokeShader extends FramebufferShader
{
    public static final SmokeShader SMOKE_SHADER;
    private float time;
    
    public SmokeShader() {
        super("smoke.frag");
    }
    
    @Override
    public void setupUniforms() {
        this.setupUniform("resolution");
        this.setupUniform("time");
    }
    
    @Override
    public void updateUniforms() {
        GL20.glUniform2f(this.getUniform("resolution"), (float)new ScaledResolution(Minecraft.func_71410_x()).func_78326_a(), (float)new ScaledResolution(Minecraft.func_71410_x()).func_78328_b());
        GL20.glUniform1f(this.getUniform("time"), this.time);
        this.time += 0.003f * RenderUtils.deltaTime;
    }
    
    static {
        SMOKE_SHADER = new SmokeShader();
    }
}
