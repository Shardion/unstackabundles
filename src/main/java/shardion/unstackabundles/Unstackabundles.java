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
            LOGGER.warn("See https://github.com/Shardion/unstackabundles/blob/master/src/main/java/shardion/unstackabundles/Unstackabundles.java.");
            /*
            No matter what you think about Quilt, I ask you please do not report issues with any of my mods
            while using it.
            
            Personally, I feel Quilt is not worth the effort of porting just yet.
            It adds barely anything while having compatibility issues with Fabric (which probably won't
            affect this mod, because it doesn't use Fabric API, but still).
             */
        }
    }
}
