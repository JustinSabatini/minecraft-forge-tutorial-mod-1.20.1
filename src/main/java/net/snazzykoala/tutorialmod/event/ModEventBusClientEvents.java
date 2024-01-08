package net.snazzykoala.tutorialmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.entity.client.FroststeelKnightModel;
import net.snazzykoala.tutorialmod.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.FROSTSTEEL_KNIGHT_LAYER, FroststeelKnightModel::createBodyLayer);
    }
}
