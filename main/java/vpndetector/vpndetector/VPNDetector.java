package vpndetector.vpndetector;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import tk.titanscripts.events.JoinEvent;

public final class VPNDetector extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[VPNDetector] Plugin Is Starting It may took A Moment...");
        Bukkit.getServer().getPluginManager().registerEvents((Listener)  new JoinEvent(this), this);




    }

    @Override
    public void onDisable() {
        System.out.println("[VPNDetector] Plugins Is Stopping It May Took A Moment ...");
    }
}
