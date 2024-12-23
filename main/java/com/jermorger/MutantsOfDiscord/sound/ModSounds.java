package com.jermorger.MutantsOfDiscord.sound;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MutantsOfDiscord.MOD_ID);

    public static final RegistryObject<SoundEvent> HAHAHA_SOUND = registerSoundEvents("eat_cocacola");
    public static final RegistryObject<SoundEvent> TEEMO_MUSHROOM_DESTROY = registerSoundEvents("teemo_mushroom_destroy");

    public static final RegistryObject<SoundEvent> CREEPY_NUTS_OTONOKE_DISC = registerSoundEvents("creepy_nuts_otonoke_disc");
    public static final RegistryObject<SoundEvent> NAPALM_DEATH_YOU_SUFFER = registerSoundEvents("napalm_death_you_suffer");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MutantsOfDiscord.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
