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
package edu.sibfu.isit.pluginz.modules.gallery.models;

import edu.sibfu.isit.pluginz.framework.Model;
import edu.sibfu.isit.pluginz.modules.main.models.MasterModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents gallery.
 * 
 * @author Max Balushkin
 */
public class GalleryModel extends Model<Map<String, Object>> {
    
    private final MasterModel master;
    private final List<ImageItem> imgs;
    
    /**
     * Creates new gallery model.
     * 
     * @param aMaster master model
     */
    public GalleryModel(MasterModel aMaster) {
        this(aMaster, new ArrayList<>());
    }
    
    /**
     * Creates new gallery model with specified list of images.
     * 
     * @param aMaster master model
     * @param aImgs images
     */
    public GalleryModel(MasterModel aMaster, List<ImageItem> aImgs) {
        master = aMaster;
        imgs = aImgs;
    }
    
    /**
     * Adds image to gallery.
     * 
     * @param aImg image
     */
    public void addImage(ImageItem aImg) {
        imgs.add(aImg);
    }

    @Override
    public Map<String, Object> get() {
        Map<String, Object> map = master.get();
        Object[] images = imgs.stream().map((item) -> item.get()).toArray();
        map.put("images", images);
        return map;
    }

}
