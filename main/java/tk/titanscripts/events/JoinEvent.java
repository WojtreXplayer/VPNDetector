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

public class JoinEvent implements Listener {
    public JoinEvent(VPNDetector vpnDetector) {
    }

    @EventHandler
    public void JoinEvent(PlayerJoinEvent join) throws Exception {
        try {

            HttpURLConnection connection = (HttpURLConnection) new URL("https://proxycheck.io/v2/" + join.getPlayer().getAddress().getAddress().toString() + "?vpn=1&asn=1").openConnection();
            connection.setDoInput(true);
            InputStream proxycheck = connection.getInputStream();


            BufferedReader isproxy = new BufferedReader(new InputStreamReader(proxycheck));

            String line1 = isproxy.readLine();
            String line2 = isproxy.readLine();
            String line3 = isproxy.readLine();
            String line4 = isproxy.readLine();
            String line5 = isproxy.readLine();
            String line6 = isproxy.readLine();
            String line7 = isproxy.readLine();
            String line8 = isproxy.readLine();
            String line9 = isproxy.readLine();
            String line10 = isproxy.readLine();
            String line11 = isproxy.readLine();
            String line12 = isproxy.readLine();
            String line13 = isproxy.readLine();
            String line14 = isproxy.readLine();
            String line15 = isproxy.readLine();
            String line16 = isproxy.readLine();
            String line17 = isproxy.readLine();
            String line18 = isproxy.readLine();


            if (line12.contains("yes")) {
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
