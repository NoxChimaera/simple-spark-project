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
package edu.sibfu.isit.pluginz;

import edu.sibfu.isit.pluginz.configuration.Configuration;
import edu.sibfu.isit.pluginz.configuration.Routing;
import edu.sibfu.isit.pluginz.framework.Controller;
import edu.sibfu.isit.pluginz.framework.Model;
import edu.sibfu.isit.pluginz.http.HttpMethod;
import edu.sibfu.isit.pluginz.modules.main.models.LinkMenuItem;
import edu.sibfu.isit.pluginz.modules.main.models.MenuItem;
import edu.sibfu.isit.pluginz.modules.main.models.MenuModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author Max Balushkin
 */
public class App {
    
    public static void main(String[] args) {
        Configuration.setTemplateEngine(new FreeMarkerEngine());
        
        Model model = new Model<Map>() {
            @Override
            public Map<String, Object> get() {
                Map<String, Object> map = new HashMap<>();
                
                List<MenuItem> items = new ArrayList<>();
                items.add(new LinkMenuItem("annicom", "http://annimon.com"));
                MenuModel menu = new MenuModel(items);
                
                map.put("title", "foobar");
                map.put("menuItems", menu.get());
                return map;
            }
        };
        
        Routing.route(HttpMethod.GET, "/", new Controller("index.html", model));
    }
    
}
