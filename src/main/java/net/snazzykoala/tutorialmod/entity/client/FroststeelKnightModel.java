package net.snazzykoala.tutorialmod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.snazzykoala.tutorialmod.entity.animations.ModAnimationDefinitions;
import net.snazzykoala.tutorialmod.entity.custom.FroststeelKnightEntity;

public class FroststeelKnightModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart froststeel_knight;
	private final ModelPart head;

	public FroststeelKnightModel(ModelPart root) {
		this.froststeel_knight = root.getChild("froststeel_knight");
		this.head = froststeel_knight.getChild("root").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition froststeel_knight = partdefinition.addOrReplaceChild("froststeel_knight", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition root = froststeel_knight.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 1.0F));

		PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -33.0F, -4.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition cube_r1 = helmet.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 4).addBox(2.0F, 3.0F, -26.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-4.0F, 3.0F, -26.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 3.0F, -29.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(52, 0).addBox(-4.0F, 3.0F, -32.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(24, 19).addBox(-5.0F, -6.0F, -32.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = helmet.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, 4.0F, -32.0F, 9.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(26, 29).addBox(-4.0F, -5.0F, -32.0F, 9.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 1.0F));

		PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 37).addBox(-4.0F, -24.0F, -1.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -22.0F, 1.0F));

		PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 38).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -22.0F, 1.0F));

		PartDefinition sword = left_arm.addOrReplaceChild("sword", CubeListBuilder.create().texOffs(0, 124).addBox(-0.5F, -14.0F, -14.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 123).addBox(-0.5F, -13.0F, -14.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(19, 123).addBox(-0.5F, -5.0F, -7.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 123).addBox(-0.5F, -3.0F, -7.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(39, 124).addBox(-0.5F, -3.0F, -3.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(46, 126).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(51, 123).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(56, 123).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(63, 125).addBox(-0.5F, -2.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(68, 125).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(73, 126).addBox(-0.5F, -8.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(73, 126).addBox(-0.5F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(78, 126).addBox(-0.5F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(83, 123).addBox(-0.5F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(94, 123).addBox(-0.5F, -7.0F, -3.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(101, 122).addBox(-0.5F, -12.0F, -14.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(114, 122).addBox(-0.5F, -11.0F, -13.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 115).addBox(-0.5F, -10.0F, -12.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(13, 115).addBox(-0.5F, -9.0F, -11.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(26, 115).addBox(-0.5F, -8.0F, -10.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(39, 115).addBox(-0.5F, -7.0F, -9.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(51, 115).addBox(-0.5F, -6.0F, -8.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK_CYCLE, limbSwing, limbSwingAmount, 1f, 1f);
		this.animate(((FroststeelKnightEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);

	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -40.0F, 40.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -30.0F, 50.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		froststeel_knight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return froststeel_knight;
	}
}