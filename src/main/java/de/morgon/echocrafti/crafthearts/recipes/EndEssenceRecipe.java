package de.morgon.echocrafti.crafthearts.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class EndEssenceRecipe {

    public static void register(NamespacedKey key) {
        ItemStack EndEssence = new ItemStack(Material.GHAST_TEAR);
        ItemMeta EndEssenceM = EndEssence.getItemMeta();
        EndEssenceM.setDisplayName("§bEssence of the End");
        EndEssence.setItemMeta(EndEssenceM);

        ShapedRecipe recipe = new ShapedRecipe(key, EndEssence);

        recipe.shape("CBC", "PEG", "COC");
        recipe.setIngredient('C', Material.END_CRYSTAL);
        recipe.setIngredient('B', Material.BROWN_SHULKER_BOX);
        recipe.setIngredient('P', Material.PEARLESCENT_FROGLIGHT);
        recipe.setIngredient('E', Material.ELYTRA);
        recipe.setIngredient('G', Material.VERDANT_FROGLIGHT);
        recipe.setIngredient('O', Material.OCHRE_FROGLIGHT);

        Bukkit.addRecipe(recipe);
    }

}