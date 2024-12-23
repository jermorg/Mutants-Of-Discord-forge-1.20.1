package com.jermorger.MutantsOfDiscord.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CigaretteItem extends Item {
    public CigaretteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if (player != null) {
            Level level = pContext.getLevel();
            BlockPos headPosition = player.blockPosition().above();

            Vec3 lookDirection = player.getLookAngle().normalize();
            int x = (int) Math.floor(headPosition.getX() + lookDirection.x * 1.5);
            int y = (int) Math.floor(headPosition.getY() + lookDirection.y * 1.5);
            int z = (int) Math.floor(headPosition.getZ() + lookDirection.z * 1.5);

            BlockPos particlePosition = new BlockPos(x, y, z);

            level.addParticle(
                    ParticleTypes.CLOUD,
                    particlePosition.getX() + 0.5,
                    particlePosition.getY() + 1.0,
                    particlePosition.getZ() + 0.5,
                    0.002,
                    0.002,
                    0.002
            );
        }

        return InteractionResult.SUCCESS;
    }
}
