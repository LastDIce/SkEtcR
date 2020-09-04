package kor.riga.sketcr;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import com.nisovin.magicspells.events.SpellApplyDamageEvent;
import com.nisovin.magicspells.events.SpellCastEvent;
import kor.riga.sketcr.Condition.CommandAynchronous;
import kor.riga.sketcr.Condition.CondEven;
import kor.riga.sketcr.Effect.*;
import kor.riga.sketcr.Event.*;
import kor.riga.sketcr.Expression.*;
import kor.riga.sketcr.etc.VersionCheck;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.entity.SlimeSplitEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin implements Listener {
    private static Main instance = null;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        //System.out.println(getDescription().getVersion());
        register();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new VersionMessage(), this);
        File file = new File("plugins\\SkEtcR\\Example.txt");
        file.delete();
        saveResource("Example.txt", false);
        this.getConfig().addDefault("개발자.닉네임", "_____R");
        this.getConfig().addDefault("개발자.디스코드", "_R#8668");
        this.getConfig().addDefault("도움을 주신 분", "디코 : 짖지리#6654, 블로그 : https://blog.naver.com/pseongsil");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        new VersionCheck().start();

    }

    @Override
    public void onDisable() {
    }


    private void register() {
        if (Bukkit.getPluginManager().getPlugin("Skript") != null) {
            Skript.registerAddon(this);
            Skript.registerExpression(ExpCooldown.class, Number.class, ExpressionType.PROPERTY,
                    "%player%'s cooldown of %string%");
            Skript.registerExpression(ExpFish.class, ItemStack.class, ExpressionType.PROPERTY,
                    "event-fish");
            Skript.registerExpression(ExpDrop.class, ItemStack.class, ExpressionType.PROPERTY,
                    "event-drop[s]");
            Skript.registerExpression(ExpGameRules.class, String.class, ExpressionType.PROPERTY,
                    "gamerule %string% at %world%");
            Skript.registerExpression(ExpAddString.class, String.class, ExpressionType.PROPERTY,
                    "combine %string%[ ]+[ ]%string%");
            Skript.registerExpression(ExpCrops_Age.class, Number.class, ExpressionType.PROPERTY,
                    "crops age %block%");
            Skript.registerExpression(Time.class, String.class, ExpressionType.PROPERTY,
                    "time %string%");
            Skript.registerExpression(File_List.class, String.class, ExpressionType.PROPERTY,
                    "file list %string%");
            Skript.registerExpression(ExpPotion.class, String.class, ExpressionType.PROPERTY,
                    "%player%'s potion[s]");
            Skript.registerExpression(File_List_Name.class, String.class, ExpressionType.PROPERTY,
                    "file list name %string%");
            Skript.registerExpression(ExpGetInventory.class, String.class, ExpressionType.PROPERTY,
                    "[%player%['s]][ ]inv[entory][ ]name");
            Skript.registerExpression(ExpEnchant.class, Number.class, ExpressionType.PROPERTY,
                    "enchant of %number% in %itemstack%");
            Skript.registerExpression(ExpAccess.class, Boolean.class, ExpressionType.PROPERTY,
                    "%player%'s access");
            Skript.registerExpression(ExpComma.class, String.class, ExpressionType.PROPERTY,
                    "%number% apply comma");
            Skript.registerExpression(ExpKeepInventory.class, Boolean.class, ExpressionType.PROPERTY,
                    "keep inventory");
            Skript.registerExpression(ExpArrayClean.class, Object.class, ExpressionType.PROPERTY,
                    "clean array %objects%");
            Skript.registerExpression(ExpSort.class, Number.class, ExpressionType.PROPERTY,
                    "sort in %numbers%");
            Skript.registerEffect(EFFEnchant.class, "clear enchant of %itemstack%");
            Skript.registerEffect(EffCmdOp.class, "%player% op c[om]m[an]d %string%");
            Skript.registerEffect(EffSort.class, "sort index %objects% value %numbers% in %string%");
            Skript.registerEffect(EffCallDamage.class, "call[ ]event damage %entity% by %entity% cause %string% damage %double%");
            Skript.registerEffect(EffCallChat.class, "call[ ]event chat %player%");
            Skript.registerEffect(EffCallJoin.class, "call[ ]event join %player%");
            Skript.registerEffect(EffCallQuit.class, "call[ ]event quit %player%");
            Skript.registerEffect(EffCallDeath.class, "call[ ]event death %player%");
            Skript.registerEffect(EffOpenInv.class, "open[ ]inv %number% and %string% to %player%");
            Skript.registerEffect(EFFBossbar.class, "send bossbar %string% with style %string% and color %string% of id %string% to %player% for %number% seconds");
            Skript.registerEffect(EFFStopBossbar.class, "stop[ ]b[oss]b[ar] id %string%");
            Skript.registerEffect(EFFBroadcastBossbar.class, "broadcast bossbar %string% with style %string% and color %string% of id %string% for %number% seconds");
            // Skript.registerEffect(EFFFalling.class, new String[] { "falling block
            // %string% with %byte% at %location%" });
            Skript.registerEffect(EFFNoteBlockFlat.class, "play noteblock flat instrument %string% and tone %string% at %location% to %player%");
            Skript.registerEffect(EFFNoteBlockNatural.class, "play noteblock natural instrument %string% and tone %string% at %location% to %player%");
            Skript.registerEffect(EFFNoteBlockSharp.class, "play noteblock sharp instrument %string% and tone %string% at %location% to %player%");
            Skript.registerEffect(EFFNotePlay.class,
                    "play noteblock %string% of %float% with volume %float% at %location%");
            Skript.registerEffect(EFFNotePlayPlayer.class,
                    "play noteblock %string% of %float% with volume %float% for %player%");
            Skript.registerEffect(EffPotionClear.class, "clear %player%'s potion[s]");
            Skript.registerEffect(EffLore.class, "lore{%itemstack%, %number%, %string%}");
            Skript.registerEffect(LoreClear.class, "clear lore of %itemstack%");
            Skript.registerEffect(EFFMessageBox.class, "messagebox %string%");
            Skript.registerEffect(EFFRunCmdCommand.class, "run cmd command %string%");
            Skript.registerEffect(EffParticle.class, "particle %string% of %integer% at %location% ([offset]XYZ|RGB) %double%[,] %double%[,] %double%");
            Skript.registerEffect(EffParticle2.class, "particle spring %string% at %location% height %double% width %double% RGB %double%[,] %double%[,] %double%");
            Skript.registerEffect(EffParticle3.class, "particle beam %string% at %location% length %integer% gap %double% RGB %double%[,] %double%[,] %double%");
            Skript.registerEffect(Memory.class, "memory optimize");
            Skript.registerEvent("Player Move", EvtPlayerMove.class, PlayerMoveEvent.class,
                    "player move [of] [%string%][,] [%string%][,] [%string%]");
            Skript.registerEvent("block grow", EvtBlockGrow.class, BlockGrowEvent.class, "[block] grow");
            Skript.registerEvent("locale", EvtLocaleChange.class, PlayerLocaleChangeEvent.class, "locale [change]");
            Skript.registerEvent("glide", EvtToggleGlide.class, EntityToggleGlideEvent.class, "toggle glide");
            Skript.registerEvent("NotePlay", EvtNotePlay.class, NotePlayEvent.class, "note play");
            Skript.registerEvent("merge", EvtItemMergeEvent.class, ItemMergeEvent.class, "[item] merge");
            Skript.registerEvent("slime", EvtSlimeSplitEvent.class, SlimeSplitEvent.class, "slime split");
            Skript.registerEvent("inv pickup", EvtInventoryPickup.class, InventoryPickupItemEvent.class,
                    "[inventory] pickup item");
            Skript.registerCondition(CommandAynchronous.class, "command (1¦is|2¦is(n't| not)) exist");
            Skript.registerCondition(CondEven.class, "%number% (1¦is|2¦is(n't| not)) even");
            // Skript.registerCondition(CondKeepInventory.class, "inventory (1¦is|2¦is(n't|
            // not)) keep");
            //MagicSpells
            if (Bukkit.getPluginManager().getPlugin("MagicSpells") != null) {
                Skript.registerEffect(EffMagicTeach.class, "[magic[ ]]teach %string% to %player%");
                Skript.registerEffect(EffMagicCast.class, "[magic[ ]]cast %string% to %player%");
                Skript.registerExpression(ExpMagicDamage.class, Number.class, ExpressionType.PROPERTY,
                        "m[agic][-]damage");
                Skript.registerExpression(ExpMagicID.class, String.class, ExpressionType.PROPERTY,
                        "m[agic][-]id");
                Skript.registerExpression(ExpMagicVictim.class, Entity.class, ExpressionType.PROPERTY,
                        "m[agic][-]victim");
                Skript.registerExpression(ExpMagicAttacker.class, Entity.class, ExpressionType.PROPERTY,
                        "m[agic][-]attacker");
                Skript.registerExpression(ExpMagicCaster.class, Player.class, ExpressionType.PROPERTY,
                        "m[agic][-]caster");
                Skript.registerExpression(ExpMagicCooldown.class, Float.class, ExpressionType.PROPERTY,
                        "m[agic][-]cooldown");
                Skript.registerEvent("damage", EvtMagicDamage.class, SpellApplyDamageEvent.class, "m[agic][ ]damage");
                Skript.registerEvent("cast", EvtMagicCast.class, SpellCastEvent.class, "m[agic][ ]cast");
            }
            return;
        }

        Bukkit.getPluginManager().disablePlugin(this);
    }
}
