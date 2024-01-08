package net.snazzykoala.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.entity.ModEntities;
import net.snazzykoala.tutorialmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> FROSTSTEEL_INGOT = ITEMS.register("froststeel_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FROSTSTEEL_NUGGET = ITEMS.register("froststeel_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FROSTSTEEL = ITEMS.register("raw_froststeel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> FROSTSTEEL_STEAK = ITEMS.register("froststeel_steak",
            () -> new Item(new Item.Properties().food(ModFoods.FROSTSTEEL_STEAK)));

    public static final RegistryObject<Item> FROSTSTEEL_KNIGHT_SPAWN_EGG = ITEMS.register("froststeel_knight_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FROSTSTEEL_KNIGHT, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
