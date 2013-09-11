/**
 * CCM Modding, Skills
 */
package ccm.skills;

import static ccm.skills.utils.lib.Archive.CLIENT_PROXY;
import static ccm.skills.utils.lib.Archive.MOD_ID;
import static ccm.skills.utils.lib.Archive.MOD_NAME;
import static ccm.skills.utils.lib.Archive.SERVER_PROXY;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import ccm.nucleum.omnium.CCMMod;
import ccm.nucleum.omnium.IMod;
import ccm.nucleum.omnium.proxy.CommonProxy;
import ccm.nucleum.omnium.utils.handler.ModLoadingHandler;

@Mod(modid = MOD_ID, name = MOD_NAME, useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Skills extends CCMMod implements IMod
{

    @Instance(MOD_ID)
    public static Skills instance;

    @SidedProxy(serverSide = SERVER_PROXY, clientSide = CLIENT_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        ModLoadingHandler.loadMod(this);

        initializeConfig(event);
        // ConfigurationHandler.init(this, Config.class);
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {}

    @EventHandler
    public void PostInit(final FMLPostInitializationEvent event)
    {}
}