package binaris.multihitboxlib.networking.server.assetsync;

import binaris.multihitboxlib.MHLibMod;
import binaris.multihitboxlib.api.network.PacketS2C;
import binaris.multihitboxlib.assetsynch.data.SynchDataContainer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class SPacketSynchAssets extends PacketS2C {
    public static final ResourceLocation CHANNEL_NAME = new ResourceLocation(MHLibMod.MODID, "synch_assets");
    protected final SynchDataContainer data;

    public SPacketSynchAssets(ServerPlayer player) {
        super(player, PacketByteBufs.empty());
        this.data = null;
    }

    public SPacketSynchAssets(ServerPlayer player, SynchDataContainer data) {
        super(player, PacketByteBufs.empty());
        this.data = data;
    }

    protected Codec<SynchDataContainer> codec() {
        return SynchDataContainer.CODEC;
    }

    protected SPacketSynchAssets createPacket(DataResult<SynchDataContainer> dr){
        SynchDataContainer sdc = dr.getOrThrow(false, (s) -> {
            //TODO
        });
        if (sdc != null) {
            return new SPacketSynchAssets(sdc);
        }
        return null;
    };
    protected SPacketSynchAssets createPacket(SynchDataContainer data){
        return new SPacketSynchAssets(data);
    };


    @Override
    public void send() {

    }

    @Override
    public void receive(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {

    }

    @Override
    public ResourceLocation getChannelName() {
        return null;
    }
}
