package kor.riga.sketcr.Effect;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import kor.riga.sketcr.Util.Variables;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EffEnableDamageParticle extends Effect {
    String str;

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "enable damage particle";
    }

    @Override
    protected void execute(Event event) {
        Variables.getInstance().damageParticle = false;
    }

}
