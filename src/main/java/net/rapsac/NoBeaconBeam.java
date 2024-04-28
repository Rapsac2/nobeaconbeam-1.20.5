package net.rapsac;

import net.fabricmc.api.ClientModInitializer;


import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoBeaconBeam implements ClientModInitializer {
	public static final String MOD_ID = "nobeaconbeam";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Boolean shouldRenderBeamBool = false;

	@Override
	public void onInitializeClient() {
		//LOGGER.info("Hello Fabric world!");
		KeyBinding RenderCpsBeam = KeyBindingHelper.registerKeyBinding(new KeyBinding("toggle Beam", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "NoBeaconBeam"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (RenderCpsBeam.wasPressed()){
				if(shouldRenderBeamBool){
					shouldRenderBeamBool = false;
				}else{
					shouldRenderBeamBool = true;
				}
			}
		});
	}
}