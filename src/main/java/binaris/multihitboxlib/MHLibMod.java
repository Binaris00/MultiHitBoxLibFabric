package binaris.multihitboxlib;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MHLibMod implements ModInitializer {
	public static final String MODID = "multihitboxlib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MODID, path);
	}
}