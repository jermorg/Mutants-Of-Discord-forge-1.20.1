package com.jermorger.MutantsOfDiscord.block;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import com.jermorger.MutantsOfDiscord.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MutantsOfDiscord.MOD_ID);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> SUGAR_BLOCK = registerBlock("sugar_block",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GRASS_BLOCK)
                    .sound(SoundType.SAND)
            ));
    public static final RegistryObject<Block> TEEMO_MUSHROOM = registerBlock("teemo_mushroom",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM)
                            .noOcclusion()
                            .noCollission()
            ));


    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
