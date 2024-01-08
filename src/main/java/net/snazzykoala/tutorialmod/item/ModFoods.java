package net.snazzykoala.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class ModFoods {
    public static final FoodProperties FROSTSTEEL_STEAK = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F).alwaysEat().build();

}
