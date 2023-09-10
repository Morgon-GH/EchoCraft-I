package de.morgon.echocrafti.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ClaimSaves {

    private static File file;
    private static FileConfiguration customFile;

    //finds or generates the config file
    public static void setup(){

        file = new File(Objects.requireNonNull(Bukkit.getServer().getPluginManager().getPlugin("EchoCraft-I")).getDataFolder(), "ClaimSaves.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ignored){}
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save ClaimSaves");
        }
    }

}
