package net.snazzykoala.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.entity.custom.FroststeelKnightEntity;

public class FroststeelKnightRenderer extends MobRenderer<FroststeelKnightEntity, FroststeelKnightModel<FroststeelKnightEntity>> {
    public FroststeelKnightRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FroststeelKnightModel<>(pContext.bakeLayer(ModModelLayers.FROSTSTEEL_KNIGHT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FroststeelKnightEntity froststeelKnightEntity) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/froststeel_knight.png");
    }

    @Override
    public void render(FroststeelKnightEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
