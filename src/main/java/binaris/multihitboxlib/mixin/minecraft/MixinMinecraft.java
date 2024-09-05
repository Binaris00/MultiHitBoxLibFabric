package binaris.multihitboxlib.mixin.minecraft;

import binaris.multihitboxlib.assetsynch.pack.AssetSynchPackFinder;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import net.minecraft.client.Minecraft;
import net.minecraft.server.packs.repository.RepositorySource;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @ModifyArg(
            method = "<init>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/repository/PackRepository;<init>([Lnet/minecraft/server/packs/repository/RepositorySource;)V"),
            index = 0
    )
    private RepositorySource[] mhlibAddPackfinder(RepositorySource[] arg) {
        return ArrayUtils.addAll(arg, AssetSynchPackFinder.instance());
    }

}