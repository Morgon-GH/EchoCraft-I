package de.morgon.echocrafti.lifesteal.heart_recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NetherEssenceRecipe {

    public static void register(NamespacedKey key) {
        ItemStack NetherEssence = new ItemStack(Material.NETHER_STAR);
        ItemMeta NetherEssenceM = NetherEssence.getItemMeta();
        NetherEssenceM.setDisplayName("§bEssence of the Nether");
        NetherEssence.setItemMeta(NetherEssenceM);

        ShapedRecipe recipe = new ShapedRecipe(key, NetherEssence);

        recipe.shape("NBN", "BMB", "NBN");
        recipe.setIngredient('N', Material.NETHER_STAR);
        recipe.setIngredient('B', Material.NETHERITE_BLOCK);
        recipe.setIngredient('M', Material.MUSIC_DISC_PIGSTEP);

        Bukkit.addRecipe(recipe);
    }

}
