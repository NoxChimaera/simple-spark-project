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
import edu.sibfu.isit.pluginz.modules.Modules;
import edu.sibfu.isit.pluginz.modules.main.MainModule;
import edu.sibfu.isit.pluginz.modules.gallery.GalleryModule;
import edu.sibfu.isit.pluginz.modules.gallery.models.ImageItem;
import edu.sibfu.isit.pluginz.modules.pages.PagesModule;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * Entry point.
 * 
 * @author Max Balushkin
 */
public class App {
    
    /**
     * Entry point.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Configuration.setTemplateEngine(new FreeMarkerEngine());
        
        MainModule main = registerMain();
        PagesModule pages = registerPages(main);
        registerGallery(main, pages);
    }
    
    /**
     * Registers main module.
     * 
     * @return main module
     */
    private static MainModule registerMain() {
        MainModule m = new MainModule();
        Modules.register(MainModule.class, m);
        return m;
    }
    
    /**
     * Registers pages module.
     * 
     * @param aMain main module
     * @return pages module
     */
    private static PagesModule registerPages(MainModule aMain) {
        PagesModule m = new PagesModule(aMain);
        Modules.register(PagesModule.class, m);
        return m;
    }
    
    /**
     * Registers gallery module.
     * 
     * @param aMain main module
     * @param aPagesModule pages module
     * @return gallery module
     */
    private static GalleryModule registerGallery(MainModule aMain, PagesModule aPagesModule) {
        GalleryModule m = new GalleryModule(aMain, aPagesModule);
        Modules.register(GalleryModule.class, m);
        
        m.addImage(new ImageItem("https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363072.jpg"));
        m.addImage(new ImageItem("https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363072.jpg"));
        m.addImage(new ImageItem("https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363072.jpg"));
        m.addImage(new ImageItem("https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363072.jpg"));
        m.addImage(new ImageItem("https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-363072.jpg"));
        
        return m;
    }
    
}
