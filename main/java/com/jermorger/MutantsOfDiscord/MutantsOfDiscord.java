package com.jermorger.MutantsOfDiscord;

import com.jermorger.MutantsOfDiscord.block.ModBlocks;
import com.jermorger.MutantsOfDiscord.effect.ModEffects;
import com.jermorger.MutantsOfDiscord.events.ModEvents;
import com.jermorger.MutantsOfDiscord.item.ModCreativeModTabs;
import com.jermorger.MutantsOfDiscord.item.ModItems;
import com.jermorger.MutantsOfDiscord.sound.ModSounds;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(MutantsOfDiscord.MOD_ID)
public class MutantsOfDiscord {
    public static final String MOD_ID = "mutantsofdiscord";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MutantsOfDiscord() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModEvents());
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
}
