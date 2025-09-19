package com.example.busbooking;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class LocalTestRunner {
    
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        
        // Set up the webapp
        String webappDirLocation = "src/main/webapp/";
        Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        
        // Add classes directory to the webapp
        File additionWebInfClasses = new File("target/classes");
        StandardRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
        
        System.out.println("Starting Tomcat on http://localhost:8080");
        System.out.println("Database: bus_db");
        System.out.println("Make sure MySQL is running and create the database with:");
        System.out.println("CREATE DATABASE bus_db;");
        
        tomcat.start();
        tomcat.getServer().await();
    }
}
