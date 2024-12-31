package com.jermorger.MutantsOfDiscord.item.custom;

import com.jermorger.MutantsOfDiscord.block.ModBlocks;
import com.jermorger.MutantsOfDiscord.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LolRandomDropItem extends Item {
    public LolRandomDropItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, net.minecraft.world.entity.player.Player player, InteractionHand hand){
        if(!level.isClientSide) {

            Random random = new Random();
            int chance = random.nextInt(100);

            if (chance < 2) {
                Map<Item, Integer> itemsWithAmounts = new HashMap<>();

                itemsWithAmounts.put(ModItems.PANTEON_TRIDENT.get(), 1);

                Item[] itemKeys = itemsWithAmounts.keySet().toArray(new Item[0]);
                Item chosenItem = itemKeys[random.nextInt(itemKeys.length)];
                int amount = itemsWithAmounts.get(chosenItem);

                ItemStack itemStack = new ItemStack(chosenItem, amount);
                player.getInventory().add(itemStack);
            } else if (chance < 5) {
                Map<Item, Integer> itemsWithAmounts = new HashMap<>();

                itemsWithAmounts.put(ModItems.EKKO_R.get(), 1);

                Item[] itemKeys = itemsWithAmounts.keySet().toArray(new Item[0]);
                Item chosenItem = itemKeys[random.nextInt(itemKeys.length)];
                int amount = itemsWithAmounts.get(chosenItem);

                ItemStack itemStack = new ItemStack(chosenItem, amount);
                player.getInventory().add(itemStack);
            } else if (chance < 30) {
                Map<Block, Integer> blocksWithAmounts = new HashMap<>();

                blocksWithAmounts.put(ModBlocks.TEEMO_MUSHROOM.get(), 4);
                blocksWithAmounts.put(Blocks.COBBLESTONE, 10);

                Map<Item, Integer> itemsWithAmounts = new HashMap<>();

                itemsWithAmounts.put(Items.DIAMOND, 1);

                boolean chooseBlock = random.nextBoolean();
                if (chooseBlock) {
                    Block[] blockKeys = blocksWithAmounts.keySet().toArray(new Block[0]);
                    Block chosenBlock = blockKeys[random.nextInt(blockKeys.length)];
                    int amount = blocksWithAmounts.get(chosenBlock);

                    ItemStack blockStack = new ItemStack(chosenBlock.asItem(), amount);
                    player.getInventory().add(blockStack);
                } else {
                    Item[] itemKeys = itemsWithAmounts.keySet().toArray(new Item[0]);
                    Item chosenItem = itemKeys[random.nextInt(itemKeys.length)];
                    int amount = itemsWithAmounts.get(chosenItem);

                    ItemStack itemStack = new ItemStack(chosenItem, amount);
                    player.getInventory().add(itemStack);
                }
            } else {
                player.sendSystemMessage(Component.translatable("chat.mutantsofdiscord:lolrandomdrop.nothing_drop"));
            }
        }

        ItemStack stack = player.getItemInHand(hand);
        stack.setCount(stack.getCount() - 1);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
