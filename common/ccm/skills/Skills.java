/**
 * CCM Modding, Skills
 */
package ccm.skills;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkMod;

import ccm.nucleum.omnium.CCMMod;
import ccm.nucleum.omnium.IMod;

@Mod(modid = "", name = "", useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Skills extends CCMMod implements IMod{

    @Instance("")
    public static Harvestry instance;
}
