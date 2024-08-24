package icu.redge.antiafkfarm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.loot.Lootable;

import java.util.*;


public class EventListener implements Listener {

    private static List<String> entityList = null;
    private static boolean isBlackList = Antiafkfarm.instance.getConfig().getBoolean("isBlackList", true);
    public EventListener(){
        getEntityList();
    }

    private void getEntityList(){
        FileConfiguration config = Antiafkfarm.instance.getConfig();
        List<String> entityList = config.getStringList("list");
        for (String entity : entityList) {
            this.entityList.add(entity.toLowerCase());
        }
    }

        boolean isBlackListMode = config.getBoolean("isBlackList", true);
        String value = e.getEntity().toString().toLowerCase();

        String entityName = e.getEntity().getType().name().toLowerCase();
        boolean isEntityInList = lowerCaseEntitySet.contains(entityName);

        boolean isPlayerKilled = e.getEntity().getKiller() instanceof org.bukkit.entity.Player;

        if(isBlackListMode) {
            //System.out.println("AntiAfkFarm TESTING! isBlackListMode");
            if(isEntityInList) {
                //System.out.println("AntiAfkFarm TESTING! isEntityInList");
                if(isPlayerKilled) {
                    //System.out.println("AntiAfkFarm TESTING! isPlayerkilled");
                }
                else {
                    //System.out.println("AntiAfkFarm TESTING! Not killed by player!");
                    e.setDroppedExp(0);
                    e.getDrops().clear();
                }
            }
            else {
                //System.out.println("Entity not in list!");
            }
        }
        else {
            //System.out.println("Blacklist mode is disabled!");
        }

    private static boolean isKillerPlayer(EntityDeathEvent e){
        return e.getEntity().getKiller() instanceof Player;
    }

    private static boolean isEntityNameInList(EntityDeathEvent e){
        return entityList.contains(e.getEntity().getType().name().toLowerCase());
    }
}
