package kor.riga.sketcr.Util;

import org.bukkit.boss.BossBar;

import java.util.HashMap;

public class Variables {
    //========================================================================
    private static Variables instance = null;
    public boolean stop;
    public boolean check;
    public HashMap<String, BossBar> bossbarList;

    private Variables() {

        bossbarList = new HashMap<>();
        stop = true;
        check = false;

    }

    public static Variables getInstance() {
        if (instance == null) {
            instance = new Variables();
        }
        return instance;
    }

}


