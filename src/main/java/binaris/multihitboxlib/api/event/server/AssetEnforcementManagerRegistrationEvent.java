package binaris.multihitboxlib.api.event.server;

import binaris.multihitboxlib.assetsynch.AbstractAssetEnforcementManager;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public interface AssetEnforcementManagerRegistrationEvent {

    Event<AssetEnforcementManagerRegistrationEvent> EVENT = EventFactory.createArrayBacked(
            AssetEnforcementManagerRegistrationEvent.class,
            (listeners) -> (map) -> {
                for (AssetEnforcementManagerRegistrationEvent listener : listeners) {
                    boolean result = listener.register(map);
                    if (!result) {
                        return false;
                    }
                }
                return true;
            }
    );

    boolean register(Map<ResourceLocation, AbstractAssetEnforcementManager> map);
}

