package de.morgon.echocrafti.rings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class UniverseIngotRecipe {

    public static void register(NamespacedKey key){
        ItemStack UniverseIngot = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta UniverseIngotM = UniverseIngot.getItemMeta();
        UniverseIngotM.setDisplayName("§bIngot of the Universe");
        UniverseIngotM.setCustomModelData(1);
        UniverseIngot.setItemMeta(UniverseIngotM);

        ShapedRecipe recipe = new ShapedRecipe(key, UniverseIngot);


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

        ItemStack moltenGold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta moltenGoldM = moltenGold.getItemMeta();
        moltenGoldM.setDisplayName(ChatColor.AQUA + "Molten Gold");
        moltenGoldM.setCustomModelData(1);
        moltenGold.setItemMeta(moltenGoldM);


        recipe.shape("GMG", "EGN", "GSG");

        recipe.setIngredient('S', new RecipeChoice.ExactChoice(SeaEssence));
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(EndEssence));
        recipe.setIngredient('M', new RecipeChoice.ExactChoice(MountainEssence));
        recipe.setIngredient('N', new RecipeChoice.ExactChoice(NetherEssence));
        recipe.setIngredient('G', new RecipeChoice.ExactChoice(moltenGold));

        Bukkit.addRecipe(recipe);

    }

}
