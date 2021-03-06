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
import java.util.Arrays;
import java.util.List;

/**
 * Base class for Pluginz module.
 * 
 * @author Max Balushkin
 */
public abstract class Module {
    
    private final String guid;
    private final List<String> dependencies;
    
    private boolean isInitialized;
    
    /**
     * Creates new module with specified GUID.
     * 
     * @param aGuid GUID
     */
    public Module(String aGuid) {
        this(aGuid, new String[] { });
    }
    
    /**
     * Creates new module with specified GUID.
     * 
     * @param aGuid GUID
     * @param aDependencies list of module dependencies
     */
    public Module(String aGuid, String ... aDependencies) {
        guid = aGuid;
        dependencies = Arrays.asList(aDependencies);
        isInitialized = false;
    }
    
    /**
     * Initializes module.
     * 
     * @throws LostDependencies if some module dependencies are lost
     */
    public void init() throws LostDependencies {
        List<String> lost = new ArrayList<>();
        for (String dependency : dependencies) {
            if (!Modules.has(dependency)) {
                lost.add(dependency);
            } else if (!Modules.get(dependency).isInitialized()) {
                lost.add(dependency);
            }
        }
        if (!lost.isEmpty()) {
            throw new LostDependencies(lost);
        }
        isInitialized = true;
    }
    
    /**
     * Returns module GUID.
     * 
     * @return GUID
     */
    public final String getGuid() {
        return guid;
    }
    
    /**
     * Returns module dependencies GUIDs.
     * 
     * @return dependencies GUIDs
     */
    public final List<String> getDependencies() {
        return dependencies;
    }
    
    /**
     * Is module initalized?
     * 
     * @return true if initialized, else false
     */
    public boolean isInitialized() {
        return isInitialized;
    }
    
    /**
     * Uninitializes module.
     */
    public void uninit() {
        isInitialized = false;
    }

    @Override
    public abstract String toString();

}
