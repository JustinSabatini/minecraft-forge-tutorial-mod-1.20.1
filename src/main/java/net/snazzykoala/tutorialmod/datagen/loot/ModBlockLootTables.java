package net.snazzykoala.tutorialmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.block.ModBlocks;
import net.snazzykoala.tutorialmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FROSTSTEEL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_FROSTSTEEL_BLOCK.get());
        this.dropSelf(ModBlocks.FROSTSTEEL_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_FROSTSTEEL_BRICKS.get());
        this.add(ModBlocks.FROSTSTEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.FROSTSTEEL_ORE.get(), ModItems.RAW_FROSTSTEEL.get()));
        this.add(ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get(), ModItems.RAW_FROSTSTEEL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
