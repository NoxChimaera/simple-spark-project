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
package edu.sibfu.isit.pluginz.modules.main;

import edu.sibfu.isit.pluginz.configuration.Routing;
import edu.sibfu.isit.pluginz.framework.RenderController;
import edu.sibfu.isit.pluginz.http.HttpMethod;
import edu.sibfu.isit.pluginz.modules.Module;
import edu.sibfu.isit.pluginz.modules.Modules;
import edu.sibfu.isit.pluginz.modules.main.models.IndexModel;
import edu.sibfu.isit.pluginz.modules.main.models.MasterModel;
import edu.sibfu.isit.pluginz.modules.main.models.MenuModel;
import java.util.ArrayList;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * Main module.
 * Routes:
 *  "/"
 * 
 * @author Max Balushkin
 */
public class MainModule extends Module {
   
    private MenuModel menu;
    
    private MasterModel master;
    private IndexModel index;
    
    /**
     * Creates main module.
     */
    public MainModule() {
        super("main");
    }

    @Override
    public void init() {
        menu = new MenuModel(new ArrayList<>());
        master = new MasterModel("Index", menu);
        index = new IndexModel(master);
        
        Routing.route(HttpMethod.GET, "/", new RenderController("index.html", index));
        Routing.route(HttpMethod.GET, "/module/on/:name", this::handle_registerModule);
        Routing.route(HttpMethod.GET, "/module/off/:name", this::handle_unregisterModule);
    }
    
    /**
     * Returns application menu.
     * 
     * @return menu
     */
    public MenuModel getMenu() {
        return menu;
    }
    
    /**
     * Returns master model (contains page title and menu).
     * 
     * @return master model
     */
    public MasterModel getMaster() {
        return master;
    }
    
    private Object handle_registerModule(Request request, Response response) throws Exception {
        String name = request.params(":name");
        Module m = Modules.get(name);
        if (m != null && !m.isInitialized()) {
            m.init();
        }
        
        response.redirect("/");
        return "";
    }
    
    private Object handle_unregisterModule(Request request, Response response) throws Exception {
        String name = request.params(":name");
        Module m = Modules.get(name);
        if (m != null && m.isInitialized()) {
            m.uninit();
        }
        
        response.redirect("/");
        return "";
    }

    @Override
    public void uninit() { }

    @Override
    public String toString() {
        return "Платформа";
    }
   
}
