package net.rapsac;

import net.fabricmc.api.ClientModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoBeaconBeam implements ClientModInitializer {
	public static final String MOD_ID = "nobeaconbeam";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello Fabric world!");
	}
}