package pl.arturm.tobacco.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import pl.arturm.tobacco.Tobacco;
import pl.arturm.tobacco.block.ModBlocks;

public class ModItems {
    // Define items with settings directly
    public static final Item TOBACCO = new Item(new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "tobacco"))));
    public static final Item TOBACCO_SEEDS = new BlockItem(ModBlocks.TOBACCO_CROP, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "tobacco_seeds"))));
    public static final Item MARIJUANA = new Item(new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "marijuana"))));
    public static final Item MARIJUANA_SEEDS = new BlockItem(ModBlocks.MARIJUANA_CROP, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "marijuana_seeds"))));
    public static final Item CIGARETTE = new CigaretteItem(new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "cigarette"))));
    public static final Item JOINT = new JointItem(new Item.Settings().registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Tobacco.MOD_ID, "joint"))));

    public static void registerModItems() {
        Tobacco.LOGGER.info("Registering Mod Items for " + Tobacco.MOD_ID);

        // Register items
        registerItem("tobacco", TOBACCO);
        registerItem("tobacco_seeds", TOBACCO_SEEDS);
        registerItem("marijuana", MARIJUANA);
        registerItem("marijuana_seeds", MARIJUANA_SEEDS);
        registerItem("cigarette", CIGARETTE);
        registerItem("joint", JOINT);

        // Add items to item groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.add(TOBACCO);
            content.add(TOBACCO_SEEDS);
            content.add(MARIJUANA);
            content.add(MARIJUANA_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.add(ModBlocks.TOBACCO_CROP.asItem());
            content.add(ModBlocks.MARIJUANA_CROP.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(CIGARETTE);
            content.add(JOINT);
        });
    }

    private static void registerItem(String name, Item item) {
        Identifier id = Identifier.of(Tobacco.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);
        Registry.register(Registries.ITEM, key, item);
    }
}