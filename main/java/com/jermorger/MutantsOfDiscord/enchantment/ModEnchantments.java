package com.jermorger.MutantsOfDiscord.enchantment;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(
            ForgeRegistries.ENCHANTMENTS, MutantsOfDiscord.MOD_ID);

    public static final RegistryObject<Enchantment> STUN = ENCHANTMENTS.register("stun", StunEnchantment::new);

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
