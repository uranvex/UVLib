package uv.uranvex.uvlib;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("UVLib by uranvex [ON]");
    }
}
