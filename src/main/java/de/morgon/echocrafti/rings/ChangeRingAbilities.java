package de.morgon.echocrafti.rings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class ChangeRingAbilities {

    public static void addAbility(String a, ItemStack r) {




        Map<String, ArrayList<String>> AbilityList = new HashMap<String, ArrayList<String>>();

        AbilityList.put("heavens",new ArrayList<>());
        AbilityList.put("astral",new ArrayList<>());
        AbilityList.put("darkness",new ArrayList<>());
        AbilityList.put("earth",new ArrayList<>());
        AbilityList.put("necromancy",new ArrayList<>());

        AbilityList.get("heavens").add("Sunray_of_Death");
        AbilityList.get("astral").add("Meteor");
        AbilityList.get("earth").add("Earthquake");
        AbilityList.get("darkness").add("Shield_of_Flames");
        AbilityList.get("necromancy").add("Lifesteal");



        if(r.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Heavens Ring")) {
            if(AbilityList.get("heavens").contains(a) || AbilityList.get("astral").contains(a) || AbilityList.get("earth").contains(a)) {

                ItemMeta ringMeta = r.getItemMeta();

                List<String> lore = ringMeta.hasLore() ? ringMeta.getLore(): new ArrayList<String>();
                lore.add(ChatColor.LIGHT_PURPLE + a.replace("_", " "));
                ringMeta.setLore(lore);
                r.setItemMeta(ringMeta);
            }
        }
    }
    public static void removeAbility(String a, ItemStack r) {

    }

}
