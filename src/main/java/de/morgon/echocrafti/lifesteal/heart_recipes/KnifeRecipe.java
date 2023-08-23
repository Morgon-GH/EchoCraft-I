package de.morgon.echocrafti.lifesteal.heart_recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class KnifeRecipe {
    public static void register(NamespacedKey key) {
        ItemStack Knife = new ItemStack(Material.IRON_SWORD);
        ItemMeta KnifeM = Knife.getItemMeta();
        KnifeM.setDisplayName("§bKnife");
        KnifeM.isUnbreakable();
        KnifeM.addEnchant(Enchantment.SILK_TOUCH, 500, true);
        KnifeM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        KnifeM.setCustomModelData(1);
        Knife.setItemMeta(KnifeM);

        ShapedRecipe recipe = new ShapedRecipe(key, Knife);

        recipe.shape("   ", " I ", "S  ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(recipe);
    }
}
