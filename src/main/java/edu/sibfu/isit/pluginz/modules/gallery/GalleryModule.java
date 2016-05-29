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
package edu.sibfu.isit.pluginz.modules.gallery;

import edu.sibfu.isit.pluginz.configuration.Routing;
import edu.sibfu.isit.pluginz.framework.Controller;
import edu.sibfu.isit.pluginz.framework.Halt;
import edu.sibfu.isit.pluginz.http.HttpMethod;
import edu.sibfu.isit.pluginz.modules.Module;
import edu.sibfu.isit.pluginz.modules.Modules;
import edu.sibfu.isit.pluginz.modules.main.MainModule;
import edu.sibfu.isit.pluginz.modules.gallery.models.GalleryModel;
import edu.sibfu.isit.pluginz.modules.gallery.models.ImageItem;
import edu.sibfu.isit.pluginz.modules.main.models.LinkMenuItem;
import edu.sibfu.isit.pluginz.modules.pages.PagesModule;

/**
 * Gallery module.
 * Routes:
 *  "/gallery"
 * 
 * @author Max Balushkin
 */
public class GalleryModule extends Module {
    
    private GalleryModel model;
    
    private PagesModule pages;
    private LinkMenuItem link;
    
    /**
     * Creates gallery module.
     */
    public GalleryModule() {
        super("gallery", "main", "pages");
    }

    @Override
    public void init() {
        super.init();
        MainModule main = Modules.get(MainModule.class);
        pages = Modules.get(PagesModule.class);
        
        model = new GalleryModel(main.getMaster());
        
        link = new LinkMenuItem("Gallery", getGuid());
        pages.addMenuItem(link);
        
        Routing.route(HttpMethod.GET, "/gallery", new Controller("gallery.html", model));
    }
    
    
    /**
     * Adds image to gallery.
     * 
     * @param aImg image
     */
    public void addImage(ImageItem aImg) {
        model.addImage(aImg);
    }

    @Override
    public void uninit() {
        pages.removeMenuItem(link);
        Routing.route(HttpMethod.GET, "/gallery", Halt.NOT_FOUND);
    }
    
}
