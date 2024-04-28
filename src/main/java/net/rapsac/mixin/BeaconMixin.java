package net.rapsac.mixin;

import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.server.MinecraftServer;
import net.rapsac.NoBeaconBeam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconBlockEntityRenderer.class)
public class BeaconMixin {
	@Inject(at = @At("HEAD"), method = "renderBeam(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/util/Identifier;FFJII[FFF)V", cancellable = true)
	private static void MixinMethode(CallbackInfo ci) {
		if(!NoBeaconBeam.shouldRenderBeamBool){
			ci.cancel();
		}
	}
}