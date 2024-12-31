package com.jermorger.MutantsOfDiscord.item;

import com.jermorger.MutantsOfDiscord.MutantsOfDiscord;
import com.jermorger.MutantsOfDiscord.item.custom.CigaretteItem;
import com.jermorger.MutantsOfDiscord.item.custom.LolRandomDropItem;
import com.jermorger.MutantsOfDiscord.item.custom.PanteonTridentItem;
import com.jermorger.MutantsOfDiscord.item.custom.TimeRewindItem;
import com.jermorger.MutantsOfDiscord.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, MutantsOfDiscord.MOD_ID);


    public static final RegistryObject<Item> COCACOLAORIGIANL = ITEMS.register("cocacolaoriginal",
            () -> new Item(new Item.Properties().food(ModFood.COLAORIGINAL)));

    public static final RegistryObject<Item> COCACOLA_999 = ITEMS.register("cocacola_999",
            () -> new Item(new Item.Properties().food(ModFood.COLA_999)));

    public static final RegistryObject<Item> OKROSHKA = ITEMS.register("okroshka",
            () -> new Item(new Item.Properties().food(ModFood.OKROSHKA).stacksTo(3)));

    public static final RegistryObject<Item> PEPSI_ORIGINAL = ITEMS.register("pepsi_original",
            () -> new Item(new Item.Properties().food(ModFood.PEPSI_ORIGINAL).stacksTo(16)));

    public static final RegistryObject<Item> LOLRANDOMDROP = ITEMS.register("lolrandomdrop",
            () -> new LolRandomDropItem(new Item.Properties()));

    public static final RegistryObject<Item> CIGARETTE = ITEMS.register("cigarette_3d",
            () -> new CigaretteItem(new Item.Properties()));

    public static final RegistryObject<Item> CREEPY_NUTS_OTONOKE_DISC = ITEMS.register("creepy_nuts_otonoke_disc",
            () -> new RecordItem(6, ModSounds.CREEPY_NUTS_OTONOKE_DISC, new Item.Properties().stacksTo(1), 3660));

    public static final RegistryObject<Item> NAPALM_DEATH_YOU_SUFFER = ITEMS.register("napalm_death_you_suffer_disc",
            () -> new RecordItem(6, ModSounds.NAPALM_DEATH_YOU_SUFFER, new Item.Properties().stacksTo(1), 60));


    public static final RegistryObject<Item> EKKO_R = ITEMS.register("ekko_r",
            () -> new TimeRewindItem(new Item.Properties()
                    .stacksTo(1)
                    .defaultDurability(50)
            ));

    public static final RegistryObject<Item> PANTEON_TRIDENT = ITEMS.register("panteon_trident",
            () -> new PanteonTridentItem(net.minecraft.world.item.Tiers.DIAMOND, 8, -2.4F, new Item.Properties()
                    .stacksTo(1)));


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
