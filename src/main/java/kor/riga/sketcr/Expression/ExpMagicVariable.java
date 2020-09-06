package kor.riga.sketcr.Expression;

import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.nisovin.magicspells.MagicSpells;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExpMagicVariable extends SimpleExpression<Double> {
    private Expression<String> name;
    private Expression<Player> player;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.player = (Expression<Player>) expressions[1];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "m[agic][ ]var[iable] %string% for %player%";
    }

    @Override
    @Nullable
    protected Double[] get(Event event) {
        Player p = player.getSingle(event);
        String n = name.getSingle(event);
        if (p != null) {
            return new Double[]{MagicSpells.getVariableManager().getValue(n, p)};
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Double> getReturnType() {
        return Double.class;
    }

    @Override
    public void change(Event event, Object[] d, ChangeMode mode) {
        if (d != null) {
            Double s = (Double) d[0];
            String n = name.getSingle(event);
            Player p = player.getSingle(event);
            if (mode == ChangeMode.SET) {
                MagicSpells.getVariableManager().set(n, p, s);
            } else if (mode == ChangeMode.ADD) {
                double v = MagicSpells.getVariableManager().getValue(n, p);
                MagicSpells.getVariableManager().set(n, p, v + s);
            } else if (mode == ChangeMode.REMOVE) {
                double v = MagicSpells.getVariableManager().getValue(n, p);
                MagicSpells.getVariableManager().set(n, p, v - s);
            }
        }
    }
}
