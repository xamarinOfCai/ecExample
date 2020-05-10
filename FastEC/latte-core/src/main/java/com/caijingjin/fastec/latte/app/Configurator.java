package com.caijingjin.fastec.latte.app;

import java.util.WeakHashMap;

/**
 * @ClassName Configurator
 * @Description
 * @Author cjj
 * @Date 2020-05-10 20:56
 * @Version 1.0
 */
public class Configurator {

    private static final WeakHashMap<String,Object>LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }



    final WeakHashMap<String,Object>getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("configuration is not ready ,call configure!");
        }
    }

    final <T> T getConfiguration(Enum<ConfigType>key){
        checkConfiguration();
        T t = (T) LATTE_CONFIGS.get(key.name());

        return t;
    }

}
