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

            String siema1 = isproxy.readLine();
            String siema2 = isproxy.readLine();
            String siema3 = isproxy.readLine();
            String siema4 = isproxy.readLine();
            String siema5 = isproxy.readLine();
            String siema6 = isproxy.readLine();
            String siema7 = isproxy.readLine();
            String siema8 = isproxy.readLine();
            String siema9 = isproxy.readLine();
            String siema10 = isproxy.readLine();
            String siema11 = isproxy.readLine();
            String siema12 = isproxy.readLine();
            String siema13 = isproxy.readLine();
            String siema14 = isproxy.readLine();
            String siema15 = isproxy.readLine();
            String siema16 = isproxy.readLine();
            String siema17 = isproxy.readLine();
            String siema18 = isproxy.readLine();


            if (siema12.contains("yes")) {
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
