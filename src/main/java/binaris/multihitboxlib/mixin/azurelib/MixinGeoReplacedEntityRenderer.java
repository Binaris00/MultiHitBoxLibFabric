package binaris.multihitboxlib.mixin.azurelib;

import binaris.multihitboxlib.client.azurelib.renderlayer.AzurelibBoneInformationCollectorLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import mod.azure.azurelib.renderer.GeoReplacedEntityRenderer;

@Mixin(GeoReplacedEntityRenderer.class)
public abstract class MixinGeoReplacedEntityRenderer {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Inject(
            method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lmod/azure/azurelib/model/GeoModel;Lmod/azure/azurelib/core/animatable/GeoAnimatable;)V",
            at = @At("TAIL")
    )
    private void mixinConstructor(CallbackInfo ci) {
        GeoReplacedEntityRenderer self = (GeoReplacedEntityRenderer)(Object)this;
        self.addRenderLayer(new AzurelibBoneInformationCollectorLayer(self));
    }

}
