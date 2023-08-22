package de.morgon.echocrafti.crafthearts.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class HeartRecipe {

    public static void register(NamespacedKey key) {
        ItemStack Heart = new ItemStack(Material.NETHER_STAR);
        ItemMeta HeartM = Heart.getItemMeta();
        HeartM.setDisplayName("§dHeart");
        HeartM.setCustomModelData(1);
        Heart.setItemMeta(HeartM);

        ShapedRecipe recipe = new ShapedRecipe(key, Heart);


        ItemStack HeartFragment = new ItemStack(Material.DIAMOND);
        ItemMeta HeartFragmentM = HeartFragment.getItemMeta();
        HeartFragmentM.setDisplayName("§dHeart Fragment");
        HeartFragmentM.setCustomModelData(1);
        HeartFragment.setItemMeta(HeartFragmentM);


        recipe.shape("HPH", "DTC", "HZH");

        recipe.setIngredient('H', new RecipeChoice.ExactChoice(HeartFragment));
        recipe.setIngredient('P', Material.PIGLIN_HEAD);
        recipe.setIngredient('D', Material.DRAGON_HEAD);
        recipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        recipe.setIngredient('C', Material.CREEPER_HEAD);
        recipe.setIngredient('Z', Material.ZOMBIE_HEAD);

        Bukkit.addRecipe(recipe);
    }
}
