package com.jermorger.MutantsOfDiscord.enchantment;

import com.jermorger.MutantsOfDiscord.effect.ModEffects;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;

public class StunEnchantment extends Enchantment {

    public StunEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof net.minecraft.world.item.SwordItem;
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return true;
    }

    public static void onAttack(LivingEntity target, ItemStack weapon) {

        int level = weapon.getEnchantmentLevel(ModEnchantments.STUN.get());

        if (level == 1) {
            applyEffectWithChance(target, new MobEffectInstance(ModEffects.STUN_EFFECT.get(), 30), 0.15); // 1.5s / 15%
        } else if (level == 2) {
            applyEffectWithChance(target, new MobEffectInstance(ModEffects.STUN_EFFECT.get(), 35), 0.30); // 1.75s / 30%
        } else if (level == 3) {
            applyEffectWithChance(target, new MobEffectInstance(ModEffects.STUN_EFFECT.get(), 35), 0.50); // 1.75s / 50%
        } else if (level == 4) {
            applyEffectWithChance(target, new MobEffectInstance(ModEffects.STUN_EFFECT.get(), 30), 0.65); // 1.5s / 65%
        }
    }

    private static void applyEffectWithChance(LivingEntity target, MobEffectInstance effect, double chance) {
        chance = Math.min(1.0, Math.max(0.0, chance));

        if (Math.random() < chance) {
            target.addEffect(effect);
        }
    }
}
