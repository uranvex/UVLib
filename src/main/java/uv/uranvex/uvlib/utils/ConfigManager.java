package uv.uranvex.uvlib.utils;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import uv.uranvex.uvlib.UVLib;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    @Getter
    public static final ConfigManager instance = new ConfigManager();
    private final Map<String, YamlConfiguration> configs = new HashMap<>();

    public void init(String... fileNames) {
        for (String fileName: fileNames) {
            fileName = fileName + ".yml";

            File file = new File(UVLib.instance.getDataFolder().getAbsolutePath() + "/" + fileName);

            if (!file.exists()) {
                UVLib.instance.saveResource(fileName, false);
            }

            configs.put(fileName, YamlConfiguration.loadConfiguration(file));
        }
    }

    public YamlConfiguration get(String configName) {
        return configs.get(configName + ".yml");
    }

}

