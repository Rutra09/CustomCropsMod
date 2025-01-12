package pl.arturm.tobacco.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import pl.arturm.tobacco.Tobacco;

public class ModBlocks {

    public static Block TOBACCO_CROP;
    public static Block MARIJUANA_CROP;

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        Identifier id = Identifier.of(Tobacco.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(Registries.BLOCK.getKey(), id);

        block.getSettings().registryKey(key);

        return Registry.register(Registries.BLOCK, key, block);
    }

    public static void registerModBlocks() {
        Tobacco.LOGGER.info("Registering ModBlocks for " + Tobacco.MOD_ID);

        // Create settings with registry key for each block
        TOBACCO_CROP = registerBlockWithoutBlockItem("tobacco_crop",
                new TobaccoCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)
                        .nonOpaque()
                        .registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(Tobacco.MOD_ID, "tobacco_crop")))));
        MARIJUANA_CROP = registerBlockWithoutBlockItem("marijuana_crop",
                new MarijuanaCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)
                        .nonOpaque()
                        .registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(Tobacco.MOD_ID, "marijuana_crop")))));
    }
}