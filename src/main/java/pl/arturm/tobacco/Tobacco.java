package pl.arturm.tobacco;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.arturm.tobacco.block.ModBlocks;
import pl.arturm.tobacco.item.ModItems;

public class Tobacco implements ModInitializer {
    public static final String MOD_ID = "customcrops";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
    }
}