package binaris.multihitboxlib.client;

import binaris.multihitboxlib.Constants;
import binaris.multihitboxlib.PartEntityManager;
import binaris.multihitboxlib.api.IMultipartEntity;
import binaris.multihitboxlib.client.azurelib.AzurelibEntityRenderEventHandler;
import binaris.multihitboxlib.client.geckolib.GeckolibEntityRenderEventHandler;
import binaris.multihitboxlib.entity.MHLibPartEntity;
import binaris.multihitboxlib.mixin.accesor.AccessorEntityRenderer;
import binaris.multihitboxlib.partentityimp.PartEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.event.GeoRenderEvent;

public abstract class EntityRenderEventHandlerCommonLogic {
	
	public static void registerRelevantEventListeners() {
		if (Constants.Dependencies.isModLoaded(Constants.Dependencies.GECKOLIB_MODID)) {
			GeoRenderEvent.Entity.Post.EVENT.register(GeckolibEntityRenderEventHandler::onPostRenderEntity);
			GeoRenderEvent.ReplacedEntity.Post.EVENT.register(GeckolibEntityRenderEventHandler::onPostRenderReplacedEntity);
		}
		if (Constants.Dependencies.isModLoaded(Constants.Dependencies.AZURELIB_MODID)) {
			mod.azure.azurelib.event.GeoRenderEvent.Entity.Post.EVENT.register(AzurelibEntityRenderEventHandler::onPostRenderEntity);
			mod.azure.azurelib.event.GeoRenderEvent.ReplacedEntity.Post.EVENT.register(AzurelibEntityRenderEventHandler::onPostRenderReplacedEntity);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected static void performCommonLogic(PoseStack poseStack, EntityRenderer<?> entityRenderer, MultiBufferSource bufferSource, float partialTick, int packedLight, Entity entitybeingRenderer) {
		if (!(entitybeingRenderer instanceof LivingEntity le)) {
			return;
		}
		if (PartEntityManager.isMultipartEntity(le) &&  entitybeingRenderer instanceof IMultipartEntity<?> ime && PartEntityManager.getParts(le) != null && PartEntityManager.getParts(le).length > 0) {
			for(PartEntity<?> part : PartEntityManager.getParts(le)) {
				if(part instanceof MHLibPartEntity<?> mhlpe) {
					if (mhlpe.hasCustomRenderer() && mhlpe.isPartEnabled()) {
						EntityRenderer<? extends MHLibPartEntity<? extends Entity>> renderer = MHLibModClient.getRendererFor(mhlpe, ((AccessorEntityRenderer)entityRenderer).getEntityRenderDispatcher());
						if (renderer == null) {
							continue;
						}

						float f = Mth.lerp(partialTick, mhlpe.yRotO, mhlpe.getYRot());

						poseStack.pushPose();

						Vec3 translate = mhlpe.position().subtract(le.position());
						poseStack.translate(translate.x(), translate.y(), translate.z());

						((EntityRenderer<MHLibPartEntity<?>>) renderer).render(mhlpe, f, partialTick, poseStack, bufferSource, packedLight);

						poseStack.popPose();
					} else {
						continue;
					}
				}
			}
		}
	}

}
