package uv.uranvex.uvlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class UVLib extends JavaPlugin {
    public static UVLib instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("UVLib by uranvex [ON]");
    }
}
