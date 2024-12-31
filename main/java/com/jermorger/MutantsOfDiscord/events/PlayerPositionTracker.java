package com.jermorger.MutantsOfDiscord.events;

import com.jermorger.MutantsOfDiscord.item.custom.TimeRewindItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

@Mod.EventBusSubscriber
public class PlayerPositionTracker {
    private static final HashMap<UUID, Queue<PlayerPosition>> playerPositions = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.level().isClientSide || !(event.player instanceof ServerPlayer serverPlayer)) return;

        UUID playerId = serverPlayer.getUUID();
        playerPositions.putIfAbsent(playerId, new LinkedList<>());

        Queue<PlayerPosition> positions = playerPositions.get(playerId);
        positions.add(new PlayerPosition(
                serverPlayer.getX(),
                serverPlayer.getY(),
                serverPlayer.getZ(),
                serverPlayer.level().dimension()
        ));

        if (positions.size() > 100) {
            positions.poll();
        }

        // Якщо гравець тримає предмет, показуй частинки
        if (serverPlayer.getMainHandItem().getItem() instanceof TimeRewindItem) {
            PlayerPosition fiveSecondsAgoPosition = getFiveSecondsAgoPosition(serverPlayer);
            if (fiveSecondsAgoPosition != null && fiveSecondsAgoPosition.dimension.equals(serverPlayer.level().dimension())) {
                ServerLevel serverLevel = (ServerLevel) serverPlayer.level();
                serverLevel.sendParticles(
                        ParticleTypes.PORTAL,                 // Тип частинок
                        fiveSecondsAgoPosition.x,             // X
                        fiveSecondsAgoPosition.y,             // Y
                        fiveSecondsAgoPosition.z,             // Z
                        10,                                   // Кількість частинок
                        0.3,                                  // Рандомний розкид по X
                        0.3,                                  // Рандомний розкид по Y
                        0.3,                                  // Рандомний розкид по Z
                        0.04                                  // Швидкість частинок
                );
            }
        }
    }

    public static PlayerPosition getFiveSecondsAgoPosition(ServerPlayer player) {
        Queue<PlayerPosition> positions = playerPositions.get(player.getUUID());
        if (positions == null || positions.size() < 100) return null;

        PlayerPosition position = (PlayerPosition) positions.toArray()[0];
        if (!position.dimension.equals(player.level().dimension())) {
            return null;
        }
        return position;
    }

    public static class PlayerPosition {
        public final double x, y, z;
        public final ResourceKey<Level> dimension;

        public PlayerPosition(double x, double y, double z, ResourceKey<Level> dimension) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dimension = dimension;
        }
    }
}
