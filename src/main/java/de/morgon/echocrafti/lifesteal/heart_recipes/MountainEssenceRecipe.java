package de.morgon.echocrafti.lifesteal.heart_recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class MountainEssenceRecipe {

    public static void register(NamespacedKey key) {
        ItemStack MountainEssence = new ItemStack(Material.ECHO_SHARD);
        ItemMeta MountainEssenceM = MountainEssence.getItemMeta();
        MountainEssenceM.setDisplayName("§bEssence of the Mountains");
        MountainEssence.setItemMeta(MountainEssenceM);

        ShapedRecipe recipe = new ShapedRecipe(key, MountainEssence);

        recipe.shape("RDR", "DMD", "RDR");
        recipe.setIngredient('R', Material.RECOVERY_COMPASS);
        recipe.setIngredient('D', Material.DEEPSLATE_DIAMOND_ORE);
        recipe.setIngredient('M', Material.MUSIC_DISC_5);

        Bukkit.addRecipe(recipe);
    }

}
