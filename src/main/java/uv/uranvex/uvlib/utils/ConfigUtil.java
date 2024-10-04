package uv.uranvex.uvlib.utils;

import uv.uranvex.uvlib.UVLib;

public class ConfigUtil {
    public static String getString(String path) {
        return HexUtil.color(UVLib.instance.getConfig().getString(path));
    }

    public static int getInt(String path) {
        return UVLib.instance.getConfig().getInt(path);
    }

    public static  Boolean getBoolean(String path){
        return UVLib.instance.getConfig().getBoolean(path);
    }
}
