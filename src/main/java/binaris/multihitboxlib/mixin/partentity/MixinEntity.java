package binaris.multihitboxlib.mixin.partentity;

import binaris.multihitboxlib.partentityimp.IEntityInterface;
import binaris.multihitboxlib.partentityimp.PartEntity;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Entity.class)
public class MixinEntity implements IEntityInterface {
    @Override
    public boolean multipart$isMultipartEntity() {
        return false;
    }

    @Override
    public @Nullable PartEntity<?>[] multipart$getParts() {
        return null;
    }
}
