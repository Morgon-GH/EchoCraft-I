package de.morgon.echocrafti.upgrades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class SilexRecipe {
    public static void register(NamespacedKey key) {
        ItemStack Silex = new ItemStack(Material.STONE);
        ItemMeta SilexM = Silex.getItemMeta();
        SilexM.setDisplayName("§bSilex");
        Silex.setItemMeta(SilexM);

        ShapedRecipe recipe = new ShapedRecipe(key, Silex);

        recipe.shape("SSS", "SNS", "SSS");
        recipe.setIngredient('S', Material.DEEPSLATE);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);

        Bukkit.addRecipe(recipe);
    }
}
