package net.snazzykoala.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FROSTSTEEL_INGOT);
        simpleItem(ModItems.FROSTSTEEL_NUGGET);
        simpleItem(ModItems.RAW_FROSTSTEEL);
        simpleItem(ModItems.FROSTSTEEL_STEAK);
        simpleItem(ModItems.METAL_DETECTOR);

        withExistingParent(ModItems.FROSTSTEEL_KNIGHT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
