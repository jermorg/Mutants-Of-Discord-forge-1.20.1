package com.jermorger.MutantsOfDiscord.item.custom;

import com.jermorger.MutantsOfDiscord.events.PlayerPositionTracker;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class TimeRewindItem extends Item {
    public TimeRewindItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, net.minecraft.world.entity.player.Player player, InteractionHand hand) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            PlayerPositionTracker.PlayerPosition position = PlayerPositionTracker.getFiveSecondsAgoPosition(serverPlayer);

            ItemStack stack = player.getItemInHand(hand);

            if (position != null) {
                serverPlayer.teleportTo(position.x, position.y, position.z);

                player.getCooldowns().addCooldown(stack.getItem(), 1200);

                stack.hurtAndBreak(1, player, (p) -> {
                    p.broadcastBreakEvent(hand);
                });
            } else {

            }

        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, java.util.List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.mutantsofdiscord.ekko_r.tooltip"));
    }

}
