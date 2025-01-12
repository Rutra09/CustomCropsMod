package pl.arturm.tobacco.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import pl.arturm.tobacco.block.ModBlocks;
import pl.arturm.tobacco.client.hud.HudRenderListener;
//import pl.arturm.tobacco.client.hud.HudRenderListener;

public class TobaccoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOBACCO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARIJUANA_CROP, RenderLayer.getCutout());
        HudRenderListener.registerHudRenderCallback();
    }
}