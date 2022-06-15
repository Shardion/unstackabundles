package shardion.unstackabundles;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unstackabundles implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("unstackabundles");

    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isModLoaded("quilt_loader")) {
            LOGGER.warn("Please do not report any issues with any of my mods while using Quilt. - shardion");
            LOGGER.warn("See https://github.com/shardion/unstackabundles/tree/master/src/main/java/shardion/unstackabundles/Unstackabundles.java.");
            /*
            No matter what you think about Quilt, I ask you please do not report issues with any of my mods
            while using it.

            IMO:
            Quilt is a useless project that shovels the burden of its poor Fabric API compatibility onto Fabric mod devs
            while doing little of substance on its own and taking from other projects and loaders freely.
            It only creates issues for everyone while further dividing the community on modloader choice.

            Noble goals, terrible implementation.

            Until Quilt becomes worth developing for (no, a single refactored API isn't enough), this warn will stay in
            all of my mods.
             */
        }
    }
}