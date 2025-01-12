package pl.arturm.tobacco.client.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Hud {
    private final MinecraftClient client;
    int width = 100;
    int height = 100;

    public Hud(MinecraftClient client) {
        this.client = client;

    }
    public int calcWidthOfText(String text) {
        return client.textRenderer.getWidth(text);
    }

    public void drawGoToSleep(DrawContext drawContext) {
        drawContext.fillGradient(0, 0, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight(), 0xFFFF0000, 0xFF0000FF);
        drawContext.drawText(client.textRenderer, "Kurwo idź spać", drawContext.getScaledWindowWidth()/2 - calcWidthOfText("Kurwo idź spać")/2
                , drawContext.getScaledWindowHeight()/2, 0xFFFFFFFF, true);
    }

    public void render(DrawContext drawContext) {
//        TextRenderer textRenderer = client.textRenderer;
//        String message = "Fabric Documentation is a work in progress. Report issues on GitHub or on Discord.";
//        int x = 10; // X position of the text
//        int y = 10; // Y position of the text
//        int color = 0xFFFFFFFF; // White color
//        textRenderer.draw(message, x,y, color, true, matrices.peek().getPositionMatrix(), client.getBufferBuilders().getEntityVertexConsumers(), TextRenderer.TextLayerType.NORMAL, 0xFFFFFF,1);
//
//        drawContext.drawText(client.textRenderer, "Hello, world!", 10, 200, 0xFFFFFFFF, false);
//
//
//        drawContext.fillGradient(0, 0, this.width, this.height, 0xFFFF0000, 0xFF0000FF);

        //next to tool bar draw gray rounded rectangle empty inside
//        drawContext.filld(0, drawContext.getScaledWindowHeight() - 20, drawContext.getScaledWindowWidth(), 20, 5, 0xFF000000);
//        drawGoToSleep(drawContext);
        renderAddictionInfo(drawContext);

    }

    public void renderAddictionInfo(DrawContext drawContext) {
        //minecraft\textures\gui\sprites\toast\
        Identifier texture = Identifier.of("minecraft", "textures/gui/sprites/toast/tutorial.png");
//        drawTexture(Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
        Function<Identifier, RenderLayer> renderLayers = RenderLayer::getEntitySolid;


    }

}