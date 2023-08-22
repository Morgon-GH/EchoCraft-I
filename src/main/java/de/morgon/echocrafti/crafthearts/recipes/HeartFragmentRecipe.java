package de.morgon.echocrafti.crafthearts.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class HeartFragmentRecipe {

    public static void register(NamespacedKey key) {
        ItemStack HeartFragment = new ItemStack(Material.DIAMOND);
        ItemMeta HeartFragmentM = HeartFragment.getItemMeta();
        HeartFragmentM.setDisplayName("§dHeart Fragment");
        HeartFragmentM.setCustomModelData(1);
        HeartFragment.setItemMeta(HeartFragmentM);

        ShapedRecipe recipe = new ShapedRecipe(key, HeartFragment);


        ItemStack SeaEssence = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta SeaEssenceM = SeaEssence.getItemMeta();
        SeaEssenceM.setDisplayName("§bEssence of the Seas");
        SeaEssence.setItemMeta(SeaEssenceM);

        ItemStack MountainEssence = new ItemStack(Material.ECHO_SHARD);
        ItemMeta MountainEssenceM = MountainEssence.getItemMeta();
        MountainEssenceM.setDisplayName("§bEssence of the Mountains");
        MountainEssence.setItemMeta(MountainEssenceM);

        ItemStack NetherEssence = new ItemStack(Material.NETHER_STAR);
        ItemMeta NetherEssenceM = NetherEssence.getItemMeta();
        NetherEssenceM.setDisplayName("§bEssence of the Nether");
        NetherEssence.setItemMeta(NetherEssenceM);

        ItemStack EndEssence = new ItemStack(Material.GHAST_TEAR);
        ItemMeta EndEssenceM = EndEssence.getItemMeta();
        EndEssenceM.setDisplayName("§bEssence of the End");
        EndEssence.setItemMeta(EndEssenceM);


        recipe.shape("SEM", "NON", "MES");

        recipe.setIngredient('S', (RecipeChoice) SeaEssence);
        recipe.setIngredient('E', (RecipeChoice) EndEssence);
        recipe.setIngredient('M', (RecipeChoice) MountainEssence);
        recipe.setIngredient('N', (RecipeChoice) NetherEssence);
        recipe.setIngredient('O', Material.ENCHANTED_GOLDEN_APPLE);

        Bukkit.addRecipe(recipe);
    }

}
