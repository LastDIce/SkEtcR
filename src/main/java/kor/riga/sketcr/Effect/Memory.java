package kor.riga.sketcr.Effect;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;


public class Memory extends Effect {
    @Override
    public String toString(Event event, boolean b) {
        return "memory optimize";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    protected void execute(Event event) {
        System.gc();
    }

}

