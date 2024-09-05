package binaris.multihitboxlib.assetsynch.impl;

import binaris.multihitboxlib.Constants;
import binaris.multihitboxlib.assetsynch.AbstractAssetEnforcementManager;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.system.NonnullDefault;


import java.io.File;
import java.util.Optional;

public abstract class MHLibEnforcementManager extends AbstractAssetEnforcementManager {

	@Override
	protected Optional<byte[]> encodeData(ResourceLocation id) {
		File location = this.getFileForId(id);
		if (!location.exists() || !location.isFile()) {
			return Optional.empty();
		}
		return Optional.ofNullable(encodeToBytes(location.toPath()));
	}

	@NonnullDefault
	@Override
	protected File createServerDirectory() {
		return new File(Constants.MHLIB_ASSET_DIR, this.getSubDirectoryName());
	}

	@NonnullDefault
	@Override
	protected File createSynchDirectory() {
		return new File(Constants.MHLIB_SYNC_DIR, this.getSubDirectoryName());
	}
	
}
