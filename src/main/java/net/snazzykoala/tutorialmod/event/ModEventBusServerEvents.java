package net.snazzykoala.tutorialmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.entity.ModEntities;
import net.snazzykoala.tutorialmod.entity.client.FroststeelKnightModel;
import net.snazzykoala.tutorialmod.entity.client.ModModelLayers;
import net.snazzykoala.tutorialmod.entity.custom.FroststeelKnightEntity;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusServerEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FROSTSTEEL_KNIGHT.get(), FroststeelKnightEntity.CreateAttributes().build());
    }
}
