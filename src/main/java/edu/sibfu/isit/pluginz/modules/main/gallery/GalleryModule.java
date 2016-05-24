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
package edu.sibfu.isit.pluginz.modules.main.gallery;

import edu.sibfu.isit.pluginz.configuration.Routing;
import edu.sibfu.isit.pluginz.framework.Controller;
import edu.sibfu.isit.pluginz.http.HttpMethod;
import edu.sibfu.isit.pluginz.modules.Module;
import edu.sibfu.isit.pluginz.modules.main.MainModule;
import edu.sibfu.isit.pluginz.modules.main.gallery.models.GalleryModel;
import edu.sibfu.isit.pluginz.modules.main.gallery.models.ImageItem;
import edu.sibfu.isit.pluginz.modules.main.models.LinkMenuItem;
import edu.sibfu.isit.pluginz.modules.pages.PagesModule;

/**
 *
 * @author Max Balushkin
 */
public class GalleryModule extends Module {
    
    private GalleryModel model;
    
    public GalleryModule(MainModule aMain, PagesModule aPages) {
        super("gallery");
        
        model = new GalleryModel(aMain.getMaster());
        
        aPages.addMenuItem(new LinkMenuItem("Gallery", getGuid()));
        
        Routing.route(HttpMethod.GET, "/gallery", new Controller("gallery.html", model));
    }
    
    public void addImage(ImageItem aImg) {
        model.addImage(aImg);
    }
    
}
