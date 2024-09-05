package binaris.multihitboxlib.init;

import binaris.multihitboxlib.MHLibMod;
import binaris.multihitboxlib.api.DatapackRegistry;
import binaris.multihitboxlib.entity.hitbox.HitboxProfile;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

import java.util.Optional;

public class MHLibDatapackLoaders {
    public static final DatapackRegistry<HitboxProfile> HITBOX_PROFILE_REGISTRY = new DatapackRegistry<>(MHLibMod.prefix("entity/hitbox_profiles"), HitboxProfile.CODEC);

    public static void init() {
        HITBOX_PROFILE_REGISTRY.registerSynchable();
    }


    public static Optional<HitboxProfile> getHitboxProfile(ResourceLocation entityID, RegistryAccess registryAccess) {
        return Optional.ofNullable(HITBOX_PROFILE_REGISTRY.get(entityID, registryAccess));
    }

    public static Optional<HitboxProfile> getHitboxProfile(EntityType<?> entityType, RegistryAccess registryAccess) {
        return getHitboxProfile(BuiltInRegistries.ENTITY_TYPE.getKey(entityType), registryAccess);
    }

}
