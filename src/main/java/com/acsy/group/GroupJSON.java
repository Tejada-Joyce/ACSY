package com.acsy.group;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.acsy.serializer.JSONSerializer;

public class GroupJSON implements JSONSerializer<Group>{
  
  private static GroupJSON single_instance = null;

  public static GroupJSON getInstance() {
    
      if(single_instance == null) {
          single_instance = new GroupJSON();
      }
      return single_instance;
  }
  @Override
  public JSONObject getJson(Group object) {
    JSONObject json = new JSONObject();
    json.put("id", object.getId());
    json.put("name", object.getName());
    json.put("status", object.isStatus());
    return json;
  }

  @Override
  public JSONObject getJsonList(List<Group> list) {
    JSONObject json = new JSONObject();
    JSONArray array = new JSONArray();
    for(Group group : list) {
      array.put(getJson(group));
    }
    json.put("groups", array);
    
    return json;
  }
  
  @Override
  public Group getNewFromString(String json) {
    JSONObject data = new JSONObject(json);
    String name = (String) data.get("name");
    Group group = new Group();
    group.setName(name);
    
    return group;
  }
  
  @Override
  public Group getExistentFromString(String json) {
    JSONObject data = new JSONObject(json);
    Integer id = Integer.parseInt((String)data.get("group_id"));
    String name = (String) data.get("name");
    Group group = GroupDAO.getInstance().get(id);
    group.setName(name);
    
    return group;
  }
  
  public Group getExistentFromStringId(String json) {
    JSONObject data = new JSONObject(json);
    Integer id = (Integer)data.get("group_id");
    Group group = GroupDAO.getInstance().get(id);
    
    return group;
  }
  
}
