package com.jermorger.MutantsOfDiscord.effect;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class ModEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MutantsOfDiscord.MOD_ID);

    public static final RegistryObject<MobEffect> STUN_EFFECT = MOB_EFFECTS.register("stun",
            () -> new StunEffect(MobEffectCategory.NEUTRAL, 0xbe22f2)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, "f2a92c3a-96ed-4c0f-b1cf-8d8e6c1f6dbe",
                            -1000F, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, "c3b12a9b-84fc-4f3b-b89b-90e276f5aadc",
                            -1000D, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    );

    public static void register(IEventBus eventBus) { MOB_EFFECTS.register(eventBus); }
}