package com.jermorger.MutantsOfDiscord.item.custom;

import com.jermorger.MutantsOfDiscord.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Properties;

public class PanteonTridentItem extends SwordItem {

    public PanteonTridentItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.UNCOMMON;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, java.util.List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.mutantsofdiscord.panteon_trident.tooltip"));
    }
}