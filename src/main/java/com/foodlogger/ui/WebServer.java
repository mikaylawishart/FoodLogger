package com.foodlogger.ui;

import com.google.gson.Gson;
import spark.TemplateEngine;

import java.util.Objects;
import java.util.logging.Logger;

import static spark.Spark.*;

public class WebServer
{

  private static final Logger LOG = Logger.getLogger(WebServer.class.getName());
  TemplateEngine engine;
  private final Gson gson;


  /**
   * URL patterns to request certain routes
   */
  public static final String HOME_URL = "/";


  public WebServer(TemplateEngine templateEngine, final Gson gson){
    Objects.requireNonNull(templateEngine, "templateEngine must not be null.");
    Objects.requireNonNull(gson, "Gson must not be null.");
    engine = templateEngine;
    this.gson = gson;
  }

  public void initialize(){
    staticFileLocation("/public");

    get(HOME_URL, new GetHomeRoute(engine));

    LOG.config("WebServer is initialized.");
  }
}
