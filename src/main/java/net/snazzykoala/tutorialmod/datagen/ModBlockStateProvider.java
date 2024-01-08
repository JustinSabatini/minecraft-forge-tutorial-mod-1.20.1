package net.snazzykoala.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.block.ModBlocks;

public class ModBlockStateProvider  extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FROSTSTEEL_BLOCK);
        blockWithItem(ModBlocks.RAW_FROSTSTEEL_BLOCK);
        blockWithItem(ModBlocks.CRACKED_FROSTSTEEL_BRICKS);
        blockWithItem(ModBlocks.FROSTSTEEL_BRICKS);
        blockWithItem(ModBlocks.FROSTSTEEL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_FROSTSTEEL_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


}
