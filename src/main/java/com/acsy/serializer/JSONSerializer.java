package com.acsy.serializer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public interface JSONSerializer<T> {
  public JSONObject getJson(T object);
  public JSONObject getJsonList(List<T> list);
  public T getNewFromString(String json);
  public T getExistentFromString(String json);
}
