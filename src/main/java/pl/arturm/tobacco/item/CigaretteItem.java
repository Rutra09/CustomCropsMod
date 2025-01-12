package pl.arturm.tobacco.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.consume.UseAction;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import net.minecraft.world.World;
import pl.arturm.tobacco.Tobacco;

public class CigaretteItem extends Item {

    private static final int MAX_DURABILITY = 4;

    public CigaretteItem(Item.Settings settings) {
        super(settings.maxDamage(MAX_DURABILITY));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT; // You might need a custom animation here
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 64; // Reduced duration to 16 ticks
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);

    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // Apply smoking effects here (particles, status effects, etc.)

        if (user instanceof ServerPlayerEntity playerEntity) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                if (stack.getDamage()+1 >= stack.getMaxDamage()) {
                    stack.decrement(1); // Remove the item when durability reaches 0
                } else stack.damage(1, playerEntity);
            }
//            Tobacco.incrementAddictionLevel(playerEntity);
//            Tobacco.resetLastSmokeTime(playerEntity);
        }

        return stack;
    }
}