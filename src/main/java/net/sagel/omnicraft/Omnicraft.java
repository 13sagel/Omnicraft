package net.sagel.omnicraft;

import net.fabricmc.api.ModInitializer;

import net.sagel.omnicraft.blocks.BlockRegistry;
import net.sagel.omnicraft.items.ItemRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Omnicraft implements ModInitializer {
	public static final String MOD_ID = "omnicraft";
    public static final Logger LOGGER = LoggerFactory.getLogger("omnicraft");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ItemRegistry.initialize();
		BlockRegistry.initialize();
	}
}