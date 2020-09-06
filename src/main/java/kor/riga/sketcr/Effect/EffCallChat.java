package kor.riga.sketcr.Effect;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashSet;
import java.util.Set;

public class EffCallChat extends Effect {
    private Expression<Player> player;

    @Override
    public String toString(Event event, boolean b) {
        return "call[ ]event chat %player% send %string%";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        return true;
    }

    @Override
    protected void execute(Event event) {
        Player player = this.player.getSingle(event);
        Set<Player> s = new HashSet<>(Bukkit.getServer().getOnlinePlayers());
        Bukkit.getServer().getPluginManager().callEvent(new AsyncPlayerChatEvent(false, player, null, s));
    }

}