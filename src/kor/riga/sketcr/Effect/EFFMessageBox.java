package kor.riga.sketcr.Effect;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

import javax.swing.*;


public class EFFMessageBox extends Effect {
    private Expression<String> message;

    @Override
    public String toString(Event event, boolean b) {
        return "messagebox %string%";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.message = (Expression<String>) expressions[0];
        return true;
    }

    @Override
    protected void execute(Event event) {
        String msg = message.getSingle(event);
        new JOptionPane();
        JOptionPane.showMessageDialog(null, msg);
    }
}

