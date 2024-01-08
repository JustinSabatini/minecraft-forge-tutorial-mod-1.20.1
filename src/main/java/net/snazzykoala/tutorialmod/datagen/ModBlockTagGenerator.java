package net.snazzykoala.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FROSTSTEEL_BLOCK.get(),
                        ModBlocks.RAW_FROSTSTEEL_BLOCK.get(),
                        ModBlocks.FROSTSTEEL_ORE.get(),
                        ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get(),
                        ModBlocks.FROSTSTEEL_BRICKS.get(),
                        ModBlocks.CRACKED_FROSTSTEEL_BRICKS.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_FROSTSTEEL_ORE.get(),
                        ModBlocks.FROSTSTEEL_ORE.get());
    }
}
