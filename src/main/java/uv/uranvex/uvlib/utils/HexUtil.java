package uv.uranvex.uvlib.utils;

import java.util.List;
import java.util.regex.Pattern;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class HexUtil {
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}");

    public static @NotNull String color(final String value) {
        return ChatColor.translateAlternateColorCodes('&', HEX_COLOR_PATTERN
                .matcher(value)
                .replaceAll(match -> List.of(match.group()).toString()));
    }
}
