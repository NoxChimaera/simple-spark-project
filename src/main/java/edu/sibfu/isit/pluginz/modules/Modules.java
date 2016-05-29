/*
 * The MIT License
 *
 * Copyright 2016 Max Balushkin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package edu.sibfu.isit.pluginz.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides modules.
 * 
 * @author Max Balushkin
 */
public class Modules {
    
    private static final Map<Class, Module> modules = new HashMap<>();
    
    /**
     * Registers module.
     * 
     * @param <T>
     * @param aClass module type
     * @param aModule module
     */
    public static <T extends Module> void set(Class<T> aClass, T aModule) {
        modules.put(aClass, aModule);
    }
    
    public static void set(Module aModule) {
        modules.put(aModule.getClass(), aModule);
    }
    
    public static <T extends Module> void unset(Class<T> aClass) {
        Module m = modules.get(aClass);
        if (m == null) return;
        m.uninit();
        modules.remove(aClass);
    }
    
    /**
     * Returns module by type.
     * 
     * @param <T>
     * @param aClass module type
     * @return module if contained in provider, else null
     */
    public static <T extends Module> T get(Class<T> aClass) {
        return aClass.cast(modules.get(aClass));
    }
    
    /**
     * Returns module by GUID.
     * 
     * @param <T>
     * @param aGuid module GUID
     * @return module if contained in provider, else null
     */
    public static <T extends Module> T get(String aGuid) {
        for (Map.Entry<Class, Module> entry : modules.entrySet()) {
            Class<T> key = entry.getKey();
            Module value = entry.getValue();
            if (aGuid.equals(value.getGuid())) {
                return key.cast(value);
            }
        }
        return null;
    }
    
    public static <T extends Module> boolean has(String aGuid) {
        Module m = get(aGuid);
        return m != null;
    }
    
    public static List<Module> getModules() {
        return new ArrayList<>(modules.values());
    }
    
}
