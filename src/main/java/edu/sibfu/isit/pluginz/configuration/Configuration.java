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
package edu.sibfu.isit.pluginz.configuration;

import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * Application configuration.
 * 
 * @author Max Balushkin
 */
public class Configuration {
    
    private static TemplateEngine templateEngine = new FreeMarkerEngine();
    
    /**
     * Sets template engine.
     * Default: FreeMarker
     * 
     * @param aEngine template engine
     */
    public static void setTemplateEngine(TemplateEngine aEngine) {
        templateEngine = aEngine;
    }
    
    /**
     * Returns template engine.
     * 
     * @return template engine
     */
    public static TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
  
}