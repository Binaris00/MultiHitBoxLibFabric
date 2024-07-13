package binaris.multihitboxlib.mixin.entity;

import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ServerEntity.class)
public abstract class MixinServerEntity {
    @Final
    @Shadow
    private Entity entity;

    @Inject(
            method = "sendDirtyEntityData()V",
            at = @At("HEAD")
    )
    private void mixinSendDirtyEntityData(CallbackInfo co) {
        if (this.entity.isMultipartEntity() && this.entity instanceof IMultipartEntity<?> ime) {
            SPacketUpdateMultipart updatePacket = new SPacketUpdateMultipart(this.entity);
            MHLibPackets.MHLIB_NETWORK.send(PacketDistributor.TRACKING_ENTITY.with(() -> this.entity), updatePacket);
        }
    }
}
