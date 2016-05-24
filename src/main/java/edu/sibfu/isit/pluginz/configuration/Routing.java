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

import edu.sibfu.isit.pluginz.framework.Controller;
import edu.sibfu.isit.pluginz.http.HttpMethod;
import spark.Spark;
import spark.TemplateEngine;

/**
 * Routing configuration.
 * 
 * @author Max Balushkin
 */
public class Routing {
    
    /**
     * Registers new route.
     * 
     * @param aMethod HTTP method, {@link HttpMethod}
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void route(HttpMethod aMethod, String aPath, Controller aCtrl) {
        switch (aMethod) {  
            case OPTIONS:
                options(aPath, aCtrl);
                break;
            case GET:
                get(aPath, aCtrl);
                break;
            case HEAD:
                head(aPath, aCtrl);
                break;
            case POST:
                post(aPath, aCtrl);
                break;
            case PUT:
                put(aPath, aCtrl);
                break;
            case PATCH:
                patch(aPath, aCtrl);
                break;
            case DELETE:
                delete(aPath, aCtrl);
                break;
            case TRACE:
                trace(aPath, aCtrl);
                break;
            case CONNECT:
                connect(aPath, aCtrl);
                break;
            default:
                throw new AssertionError(aMethod.name());  
        }
    }
    
    /**
     * Registers new OPTIONS route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void options(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.options(aPath, aCtrl, engine);
    }
    
    /**
     * Registers new GET route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void get(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.get(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new HEAD route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void head(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.head(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new POST route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void post(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.post(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new PUT route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void put(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.put(aPath, aCtrl, engine);
    }
       
    /**
     * Registers new PATCH route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void patch(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.patch(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new DELETE route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void delete(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.delete(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new TRACE route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void trace(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.trace(aPath, aCtrl, engine);
    }
        
    /**
     * Registers new CONNECT route.
     * 
     * @param aPath route path
     * @param aCtrl route controller
     */
    public static void connect(String aPath, Controller aCtrl) {
        TemplateEngine engine = Configuration.getTemplateEngine();
        Spark.connect(aPath, aCtrl, engine);
    }
    
}
