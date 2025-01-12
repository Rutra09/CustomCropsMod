package pl.arturm.tobacco.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;

public class HudRenderListener implements HudRenderCallback {
    private final Hud hud;

    public HudRenderListener() {
        this.hud = new Hud(MinecraftClient.getInstance());
    }

//    @Override
//    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
//        hud.render(matrixStack);
//    }

    public static void registerHudRenderCallback() {
        HudRenderCallback.EVENT.register(new HudRenderListener());
    }

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        hud.render(drawContext);
    }
}