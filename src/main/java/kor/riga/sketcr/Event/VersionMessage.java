package kor.riga.sketcr.Event;


import kor.riga.sketcr.Main;
import kor.riga.sketcr.Util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionMessage implements Listener {

    @EventHandler
    public void onjoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            if (Variables.getInstance().check) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                    player.sendMessage("§a[ SkEtcR ] 최신버전이 존재합니다 ( 문의 : _R#8668 )");
                    player.sendMessage("§a[ SkEtcR ] 애드온 다운로드 블로그 : https://blog.naver.com/pseongsil/222042861602");
                }, 15L);
            }
        }
    }
}
