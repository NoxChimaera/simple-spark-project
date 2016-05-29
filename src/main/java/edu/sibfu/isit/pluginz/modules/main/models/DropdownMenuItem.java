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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents dropdown menu.
 * 
 * @author Max Balushkin
 */
public class DropdownMenuItem extends MenuItem {

    private String name;
    private List<MenuItem> items;
   
    /**
     * Creates new dropdown.
     * 
     * @param aName name
     */
    public DropdownMenuItem(String aName) {
        super(Type.Dropdown);
        name = aName;
        items = new ArrayList<>();
    }
    
    /**
     * Creates new dropdown with specified list of items.
     * 
     * @param aName name
     * @param aItems items
     */
    public DropdownMenuItem(String aName, List<MenuItem> aItems) {
        super(Type.Dropdown);
        name = aName;
        items = aItems;
    }
    
    /**
     * Adds item to dropdown.
     * 
     * @param aItem item
     */
    public void add(MenuItem aItem) {
        items.add(aItem);
    }
    
    public void remove(MenuItem aItem) {
        items.remove(aItem);
    }

    @Override
    public Map<String, Object> get() {
        Map<String, Object> map = Model.map();
        map.put("type", getType().toString().toLowerCase());
        map.put("name", name);
        map.put("items", items.stream().map((item) -> item.get()).toArray());
        return map;
    }
    
}
