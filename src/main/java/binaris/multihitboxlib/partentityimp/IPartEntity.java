package binaris.multihitboxlib.partentityimp;

import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.protocol.Packet;

public interface IPartEntity<T extends Entity> {
    T getParent();
    Packet<ClientGamePacketListener> getAddEntityPacket();
}
