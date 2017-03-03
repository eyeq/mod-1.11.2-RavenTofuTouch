package eyeq.raventofutouch;

import eyeq.raventofutouch.event.RavenTofuTouchEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.raventofutouch.RavenTofuTouch.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
@Mod.EventBusSubscriber
public class RavenTofuTouch {
    public static final String MOD_ID = "eyeq_raventofutouch";

    @Mod.Instance(MOD_ID)
    public static RavenTofuTouch instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new RavenTofuTouchEventHandler());
    }
}
