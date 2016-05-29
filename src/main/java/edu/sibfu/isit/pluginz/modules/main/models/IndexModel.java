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
package edu.sibfu.isit.pluginz.modules.main.models;

import edu.sibfu.isit.pluginz.framework.Model;
import edu.sibfu.isit.pluginz.modules.Module;
import edu.sibfu.isit.pluginz.modules.Modules;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Max Balushkin
 */
public class IndexModel extends Model<Map<String, Object>> {
   
    private MasterModel master;
    
    /**
     * Creates new master model.
     */
    public IndexModel(MasterModel aMaster) {
        master = aMaster;
    }
    
    @Override
    public Map<String, Object> get() {
        Map<String, Object> map = Model.map();
        map.put("master", master.get());
        
        List<Module> modulesObj = Modules.getModules();
        List<Map<String, Object>> modules = new ArrayList<>();
        for (Module m : modulesObj) {
            if ("main".equals(m.getGuid())) continue;
            
            Map<String, Object> mm = Model.map();
            mm.put("name", m.toString());
            mm.put("guid", m.getGuid());
            mm.put("status", m.isInitialized());
            modules.add(mm);
        }
        
        map.put("modules", modules);
        return map;
    }
     
}
