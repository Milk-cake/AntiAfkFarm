package icu.redge.antiafkfarm;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.*;


public class EventListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public final void onMobDeath(EntityDeathEvent e) {

        FileConfiguration config = Antiafkfarm.instance.getConfig();

        List<String> entityList = config.getStringList("list");
        Set<String> lowerCaseEntitySet = new HashSet<>();
        for (String entity : entityList) {
            lowerCaseEntitySet.add(entity.toLowerCase());
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
    }
}
