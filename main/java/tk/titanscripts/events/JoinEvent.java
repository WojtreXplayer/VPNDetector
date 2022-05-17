package tk.titanscripts.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vpndetector.vpndetector.VPNDetector;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

public class JoinEvent implements Listener {
    public JoinEvent(VPNDetector vpnDetector) {
    }

    @EventHandler
    public void JoinEvent(PlayerJoinEvent join) throws Exception {
        try {
            int lengthoflines = 0;

            HttpURLConnection connection = (HttpURLConnection) new URL("https://proxycheck.io/v2/" + join.getPlayer().getAddress().getAddress().toString() + "?vpn=1&asn=1").openConnection();
            connection.setDoInput(true);
            InputStream proxycheck = connection.getInputStream();



            BufferedReader isproxy = new BufferedReader(new InputStreamReader(proxycheck));
            String[] lines = new String[]{};
            for(String lineslength = isproxy.readLine(); lineslength != null; lineslength = isproxy.readLine()){
                lines[lengthoflines] = lineslength;
                lengthoflines = lengthoflines + 1;



            }






            if (lines[12].contains("yes")) {
                join.getPlayer().kickPlayer("[VPNDetector] You Using Proxy or VPN");
                System.out.println("[VPNDetector] User " + join.getPlayer().getName() + " use VPN");

            } else {
                System.out.println("[VPNDetector] User " + join.getPlayer().getName() + " don't use VPN");


            }
        }catch(Exception exception){
            System.out.println("[VPNDetector] Daily ProxyCheck rate limit reached");

        }
    }
}
