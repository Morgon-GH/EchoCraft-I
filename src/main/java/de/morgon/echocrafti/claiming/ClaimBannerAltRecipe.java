package de.morgon.echocrafti.claiming;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ClaimBannerAltRecipe {

    public static void register(NamespacedKey key) {
        ItemStack ClaimBanner = new ItemStack(Material.WHITE_BANNER);
        ItemMeta ClaimBannerM = ClaimBanner.getItemMeta();
        ClaimBannerM.setDisplayName("§bClaimBanner");
        ClaimBanner.setItemMeta(ClaimBannerM);

        ShapelessRecipe recipe = new ShapelessRecipe(key, ClaimBanner);

        recipe.addIngredient(new RecipeChoice.ExactChoice(ClaimBanner));

        Bukkit.addRecipe(recipe);
    }

}
