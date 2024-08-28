package binaris.multihitboxlib.mixin.partentity.content;

import org.jetbrains.annotations.Nullable;

public interface IEntityInterface {
    boolean multipart$isMultipartEntity();

    @Nullable
    PartEntity<?>[] multipart$getParts();
}
