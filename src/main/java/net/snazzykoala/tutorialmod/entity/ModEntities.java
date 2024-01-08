package net.snazzykoala.tutorialmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.snazzykoala.tutorialmod.TutorialMod;
import net.snazzykoala.tutorialmod.entity.custom.FroststeelKnightEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<FroststeelKnightEntity>> FROSTSTEEL_KNIGHT =
            ENTITY_TYPES.register("froststeel_knight", () -> EntityType.Builder.of(FroststeelKnightEntity::new, MobCategory.MONSTER)
                    .sized(1f,2f).build("froststeel_knight"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
