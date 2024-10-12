package uv.uranvex.uvlib.utils;

import uv.uranvex.uvlib.Main;

public class ConfigUtil {
    public static String getString(String path) {
        return HexUtil.color(Main.instance.getConfig().getString(path));
    }

    public static int getInt(String path) {
        return Main.instance.getConfig().getInt(path);
    }

    public static  Boolean getBoolean(String path){
        return Main.instance.getConfig().getBoolean(path);
    }
}
