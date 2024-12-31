package com.jermorger.MutantsOfDiscord.events;

import com.jermorger.MutantsOfDiscord.block.ModBlocks;
import com.jermorger.MutantsOfDiscord.effect.ModEffects;
import com.jermorger.MutantsOfDiscord.enchantment.StunEnchantment;
import com.jermorger.MutantsOfDiscord.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ModEvents {

    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player player) {

            if (player.hasEffect(ModEffects.STUN_EFFECT.get())) {
                player.setDeltaMovement(player.getDeltaMovement().x, 0, player.getDeltaMovement().z);
            }
        }
    }

//    @SubscribeEvent
//    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        Player player = event.player;
//
//        System.out.println(player.level().getBlockState(player.blockPosition()).getBlock());
//
//        // Перевірка, чи є блок під гравцем акацієвим деревом
//        if (player.level().getBlockState(player.blockPosition()).getBlock() == ModBlocks.TEEMO_MUSHROOM.get()) {
//            // Додати ефект швидкості
//            createPoisonField(player);
//        }
//    }

    @SubscribeEvent
    public void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.level instanceof ServerLevel serverLevel) {
            serverLevel.getAllEntities().forEach(entity -> {
                if (entity instanceof LivingEntity livingEntity) {
                    BlockPos entityPos = livingEntity.blockPosition();

                    if (serverLevel.getBlockState(entityPos).getBlock() == ModBlocks.TEEMO_MUSHROOM.get()) {
                        createPoisonField(livingEntity);
                    }
                }
            });
        }
    }


    @SubscribeEvent
    public void onLivingHurt(net.minecraftforge.event.entity.living.LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            if (attacker.getMainHandItem().isEnchanted()) {
                StunEnchantment.onAttack(event.getEntity(), attacker.getMainHandItem());
            }
        }
    }


    private void createPoisonField(LivingEntity entity) {
        Vec3 position = entity.position();

        AreaEffectCloud poisonCloud = new AreaEffectCloud(entity.level(), position.x, position.y, position.z);
        poisonCloud.setParticle(ParticleTypes.EFFECT);
        poisonCloud.setFixedColor(0x32CD32);
        poisonCloud.setRadius(5.0F);
        poisonCloud.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 1));
        poisonCloud.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1));
        poisonCloud.setDuration(100);
        poisonCloud.setRadiusPerTick(-0.05F);
        entity.level().addFreshEntity(poisonCloud);

        BlockPos entityPos = entity.blockPosition();
        entity.level().removeBlock(entityPos, false);

//        entity.level().explode(
//                entity,
//                entity.getX(),
//                entity.getY(),
//                entity.getZ(),
//                250.0f,
//                false,
//                Level.ExplosionInteraction.BLOCK
//        );

        entity.level().playSound(
                null,
                position.x,
                position.y,
                position.z,
                ModSounds.TEEMO_MUSHROOM_DESTROY.get(),
                SoundSource.BLOCKS,
                1.0F,
                1.0F
        );
    }
}
