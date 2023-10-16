package de.morgon.echocrafti.cosmetics.customHeads;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

public class customHeadBuilder {

    public static SkullMeta createSkullTexture(String url, ItemStack skull) throws MalformedURLException {

        SkullMeta textureData = (SkullMeta) skull.getItemMeta();

        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
        profile.getTextures().setSkin(URI.create(url).toURL());
        textureData.setOwnerProfile(profile);

        return null;
    }

}
