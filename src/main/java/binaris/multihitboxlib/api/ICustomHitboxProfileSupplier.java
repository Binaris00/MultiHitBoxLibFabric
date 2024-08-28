package binaris.multihitboxlib.api;

import binaris.multihitboxlib.entity.hitbox.HitboxProfile;

import java.util.Optional;

public interface ICustomHitboxProfileSupplier {

    public Optional<HitboxProfile> getHitboxProfile();

}
