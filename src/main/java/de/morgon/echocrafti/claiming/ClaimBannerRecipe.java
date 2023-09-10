package de.morgon.echocrafti.claiming;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ClaimBannerRecipe {

    public static void register(NamespacedKey key) {
        ItemStack ClaimBanner = new ItemStack(Material.WHITE_BANNER);
        ItemMeta ClaimBannerM = ClaimBanner.getItemMeta();
        ClaimBannerM.setDisplayName("§bClaimBanner");
        ClaimBanner.setItemMeta(ClaimBannerM);

        ShapedRecipe recipe = new ShapedRecipe(key, ClaimBanner);

        recipe.shape(" B ", " C ", " L ");
        recipe.setIngredient('C', Material.COMPASS);
        recipe.setIngredient('B', Material.WHITE_BANNER);
        recipe.setIngredient('L', Material.LODESTONE);

        Bukkit.addRecipe(recipe);
    }

}
