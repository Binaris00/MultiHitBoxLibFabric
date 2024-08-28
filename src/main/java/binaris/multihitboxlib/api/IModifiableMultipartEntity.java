package binaris.multihitboxlib.api;

import binaris.multihitboxlib.entity.MHLibPartEntity;
import binaris.multihitboxlib.entity.hitbox.SubPartConfig;
import net.minecraft.world.entity.Entity;

public interface IModifiableMultipartEntity<T extends Entity> extends IMultipartEntity<T> {

    public default MHLibPartEntity<? extends T> createSubPart(final T parentEntity, final SubPartConfig properties) {
        return new MHLibPartEntity<T>(parentEntity, properties);
    }

}