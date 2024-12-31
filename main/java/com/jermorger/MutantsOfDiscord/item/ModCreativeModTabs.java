package com.jermorger.MutantsOfDiscord.item;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import com.jermorger.MutantsOfDiscord.block.ModBlocks;
import com.jermorger.MutantsOfDiscord.enchantment.ModEnchantments;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MutantsOfDiscord.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MUTANTSOFDISCORD_TAB = CREATIVE_MODE_TABS.register("mutantsofdiscord_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COCACOLAORIGIANL.get()))
                .title(Component.translatable("creativetab.mutantsofdiscord"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.COCACOLAORIGIANL.get());
                    pOutput.accept(ModItems.COCACOLA_999.get());
                    pOutput.accept(ModItems.PEPSI_ORIGINAL.get());
                    pOutput.accept(ModItems.LOLRANDOMDROP.get());
                    pOutput.accept(ModItems.OKROSHKA.get());
                    pOutput.accept(ModItems.EKKO_R.get());
//                    pOutput.accept(ModItems.CIGARETTE.get());
                    pOutput.accept(ModItems.PANTEON_TRIDENT.get());
                    pOutput.accept(ModItems.CREEPY_NUTS_OTONOKE_DISC.get());
                    pOutput.accept(ModItems.NAPALM_DEATH_YOU_SUFFER.get());

                    pOutput.accept(ModBlocks.SUGAR_BLOCK.get());
                    pOutput.accept(ModBlocks.TEEMO_MUSHROOM.get());
                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
