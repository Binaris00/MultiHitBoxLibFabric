package binaris.multihitboxlib.mixin.geckolib;

import binaris.multihitboxlib.client.geckolib.renderlayer.GeckolibBoneInformationCollectorLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

@Mixin(GeoReplacedEntityRenderer.class)
public abstract class MixinGeoReplacedEntityRenderer {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Inject(
            method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lsoftware/bernie/geckolib/model/GeoModel;Lsoftware/bernie/geckolib/core/animatable/GeoAnimatable;)V",
            at = @At("TAIL")
    )
    private void mixinConstructor(CallbackInfo ci) {
        GeoReplacedEntityRenderer self = (GeoReplacedEntityRenderer)(Object)this;
        self.addRenderLayer(new GeckolibBoneInformationCollectorLayer(self));
    }

}
