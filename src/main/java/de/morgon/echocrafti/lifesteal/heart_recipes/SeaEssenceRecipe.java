package de.morgon.echocrafti.lifesteal.heart_recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class SeaEssenceRecipe {

    public static void register(NamespacedKey key) {
        ItemStack SeaEssence = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta SeaEssenceM = SeaEssence.getItemMeta();
        SeaEssenceM.setDisplayName("§bEssence of the Seas");
        SeaEssence.setItemMeta(SeaEssenceM);

        ShapedRecipe recipe = new ShapedRecipe(key, SeaEssence);

        recipe.shape("CTC", "PHS", "CQC");
        recipe.setIngredient('C', Material.CONDUIT);
        recipe.setIngredient('H', Material.TURTLE_HELMET);
        recipe.setIngredient('P', Material.PITCHER_POD);
        recipe.setIngredient('T', Material.TORCHFLOWER);
        recipe.setIngredient('S', Material.TORCHFLOWER_SEEDS);
        recipe.setIngredient('Q', Material.PITCHER_PLANT);

        Bukkit.addRecipe(recipe);
    }

}
