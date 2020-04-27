package com.foodlogger.ui;

import com.foodlogger.util.Message;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class GetHomeRoute implements Route
{
  TemplateEngine engine;
  static final String VIEW_NAME = "home.ftl";

  static final String TITLE_ATTR = "title";
  static final String MESSAGE = "Welcome to the homepage";
  static final Message.Type MESSAGE_TYPE = Message.Type.INTRO;
  static final String INTRO_MESSAGE_ATTR = "introMessage";


  static final String TITLE = "Welcome to FoodLogger";

  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());
  public GetHomeRoute(final TemplateEngine engine){
    this.engine = engine;
    LOG.config("GetHomeRoute is initialized");
  }

  @Override
  public Object handle(Request request, Response response){

    LOG.finer("GetHomeRoute is invoked");

    final Map<String, Object> vm = new HashMap<>();
    vm.put(TITLE_ATTR, TITLE);

    Message message = new Message(MESSAGE, MESSAGE_TYPE);

    vm.put(INTRO_MESSAGE_ATTR, message.getMessageText());
    System.out.println(vm);

    return engine.render(new ModelAndView(vm, VIEW_NAME));
  }
}
