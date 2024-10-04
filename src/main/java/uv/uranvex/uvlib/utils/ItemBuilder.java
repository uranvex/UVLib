package uv.uranvex.uvlib.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    // Пример как использовать:
    //  player.getInventory().addItem(new ItemBuilder(Material.DIAMOND, 1)
    //      .displayName("config", "item.name")
    //      .addGlow()
    //      .setLore("config", "item.lore")
    //      .addPersistent("trap", PersistentDataType.STRING, "")
    //      .addEnchantment(Enchantment.DIG_SPEED, 10)
    //      .build()
    //  );


    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    // Из конфига
    public ItemBuilder displayName(String nameConfig, String value) {
        itemMeta.setDisplayName(HexUtil.color(ConfigManager.getInstance().get(nameConfig).getString(value)));

        return this;
    }

    // Из конфига
    public ItemBuilder setLore(String nameConfig, String path) {
        final List<String> lore = new ArrayList<>();
        ConfigManager.getInstance().get(nameConfig).getStringList(path).forEach(str -> lore.add(HexUtil.color(str)));
        itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder addPersistent(String key, PersistentDataType dataType, Object value) {
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString(key), dataType, value);

        return this;
    }
    public ItemBuilder addGlow() {
        itemMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int lvl) {
        itemMeta.addEnchant(enchantment, lvl, false);

        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
