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
package edu.sibfu.isit.pluginz.modules.pages;

import edu.sibfu.isit.pluginz.modules.Module;
import edu.sibfu.isit.pluginz.modules.Modules;
import edu.sibfu.isit.pluginz.modules.main.MainModule;
import edu.sibfu.isit.pluginz.modules.main.models.DropdownMenuItem;
import edu.sibfu.isit.pluginz.modules.main.models.MenuItem;

/**
 * Pages module.
 * 
 * @author Max Balushkin
 */
public class PagesModule extends Module {
    
    private DropdownMenuItem dropdown;
    private MainModule main;
    
    /**
     * Creates pages module.
     */
    public PagesModule() {
        super("pages", "main");
    }

    @Override
    public void init() {
        super.init();
        main = Modules.get(MainModule.class);
        dropdown = new DropdownMenuItem("Pages");
        main.getMenu().add(dropdown);
    }
    
    /**
     * Adds item to pages menu.
     * 
     * @param aItem item
     */
    public void addMenuItem(MenuItem aItem) {
        dropdown.add(aItem);
    }
    
    /**
     * Removes item from menu.
     *
     * @param aItem item
     */
    public void removeMenuItem(MenuItem aItem) {
        dropdown.remove(aItem);
    }

    @Override
    public void uninit() {
        super.uninit();
        main.getMenu().remove(dropdown);
    }

    @Override
    public String toString() {
        return "Страницы";
    }
    
}
