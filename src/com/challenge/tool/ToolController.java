package com.challenge.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller class to handle requests
 */
public class ToolController {
    private Tool model;
    private ToolView view;

    public ToolController(Tool model, ToolView view){
        this.model = model;
        this.view = view;
    }

    public void setToolCode(String type){
        model.setToolCode(type);
    }

    public String getToolCode(){
        return this.getToolCode();
    }

}
