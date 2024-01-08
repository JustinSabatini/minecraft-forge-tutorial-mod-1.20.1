package net.snazzykoala.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FROSTSTEEL_INGOT.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FROSTSTEEL_INGOT.get());
                        output.accept(ModItems.FROSTSTEEL_NUGGET.get());
                        output.accept(ModItems.RAW_FROSTSTEEL.get());
                        output.accept(ModBlocks.FROSTSTEEL_BLOCK.get());
                        output.accept(ModBlocks.RAW_FROSTSTEEL_BLOCK.get());
                        output.accept(ModBlocks.FROSTSTEEL_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get());
                        output.accept(ModBlocks.FROSTSTEEL_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_FROSTSTEEL_BRICKS.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.FROSTSTEEL_STEAK.get());
                        output.accept(ModItems.FROSTSTEEL_KNIGHT_SPAWN_EGG.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
