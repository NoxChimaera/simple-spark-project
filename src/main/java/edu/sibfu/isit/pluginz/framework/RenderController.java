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
package edu.sibfu.isit.pluginz.framework;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * Route controller.
 * 
 * @author Max Balushkin
 */
public class RenderController implements TemplateViewRoute {

    private final String template;
    private Model model;
    
    /**
     * Creates new route controller.
     * 
     * @param aTemplate view
     */
    public RenderController(String aTemplate) {
        template = aTemplate;
        model = Model.empty();
    }
    
    /**
     * Creates new route controller and binds it with model.
     * 
     * @param aTemplate view
     * @param aModel model
     */
    public RenderController(String aTemplate, Model aModel) {
        template = aTemplate;
        model = aModel;
    }
    
    /**
     * Returns template name.
     * 
     * @return template name
     */
    public String getTemplate() {
        return template;
    }
    
    /**
     * Sets model.
     * 
     * @param aModel model
     */
    public void setModel(Model aModel) {
        model = aModel;
    }
    
    /**
     * Returns model.
     * 
     * @return model
     */
    public Model getModel() {
        return model;
    }
    
    @Override
    public ModelAndView handle(Request aRqst, Response aRspns) throws Exception {
        return new ModelAndView(model.get(), template);
    }
    
}
