package kor.riga.sketcr.etc;

import kor.riga.sketcr.Main;
import kor.riga.sketcr.Util.Variables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class VersionCheck extends Thread implements Runnable {

    private boolean check = false;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public void run() {
        String u = "https://pastebin.com/raw/gmyCL1Eg";
        BufferedReader ur;
        try {
            ur = new BufferedReader(new InputStreamReader((new URL(u)).openStream(), StandardCharsets.UTF_8));
            String[] sy = ur.lines().toArray(String[]::new);
            if (!sy[0].equals(Main.getInstance().getDescription().getVersion())) {
                Variables.getInstance().check = true;
                System.out.println("[SkEtcR] 최신버전이 존재합니다 ( 디스코드 _R#8668 )");
                System.out.println("[SkEtcR] 최신버전이 존재합니다 ( 디스코드 _R#8668 )");
                System.out.println("[SkEtcR] 최신버전이 존재합니다 ( 디스코드 _R#8668 )");
                System.out.println("[SkEtcR] 최신버전이 존재합니다 ( 디스코드 _R#8668 )");
                System.out.println("[SkEtcR] 최신버전이 존재합니다 ( 디스코드 _R#8668 )");
                System.out.println("[SkEtcR] 블로그 : https://blog.naver.com/pseongsil/222042861602");
            }
        } catch (IOException e) {
        }
    }
}
