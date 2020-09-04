package kor.riga.sketcr.Effect;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class LoreClear extends Effect {
    private Expression<ItemStack> item;

    @Override
    public String toString(Event event, boolean b) {
        return "clear lore of %itemstack%";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.item = (Expression<ItemStack>) expressions[0];
        return true;
    }

    @Override
    protected void execute(Event event) {
        ItemStack i = item.getSingle(event);
        ItemMeta im = i.getItemMeta();
        im.setLore(null);
        i.setItemMeta(im);
    }

}

