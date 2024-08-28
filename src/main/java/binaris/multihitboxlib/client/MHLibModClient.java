package binaris.multihitboxlib.client;

import binaris.multihitboxlib.MHLibMod;
import net.fabricmc.api.ClientModInitializer;

public class MHLibModClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        MHLibMod.LOGGER.info("Hello Fabric world! (Client)");


    }
}
