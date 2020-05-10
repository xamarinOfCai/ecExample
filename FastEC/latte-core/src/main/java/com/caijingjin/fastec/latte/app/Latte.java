package com.caijingjin.fastec.latte.app;

import android.content.Context;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @ClassName Latte
 * @Description
 * @Author cjj
 * @Date 2020-05-10 20:53
 * @Version 1.0
 */
public final class Latte {

    public static Configurator init(Context context){
        getConiguration().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();

    }

    private static WeakHashMap<String, Object> getConiguration() {
        return Configurator.getInstance().getLatteConfigs();
    }

}
