package com.Sztomberska.utils;

import java.lang.reflect.Array;

public class IntelligentList<T> {
  
  private Object[] array;

  private int index=0;

  private Class<T> type;

  public IntelligentList(Class<T> type) {
    this.type = type;
    array = getNewArray(10);
  }

  public void add(T T){
    if(index == array.length - 1){
      T[]newTs = getNewArray(array.length + 10);
      for (int i = 0; i < array.length; i++) {
        newTs[i]= (T) array[i];
      }
      array =newTs;
    }
    array[index]=T;
    index++;
  }

  public T[] getAll(){
    T [] T = getNewArray(index);
    for (int i = 0; i < T.length; i++) {
      T[i]= (T) array[i];
    }
    return T;
  }

  private T[] getNewArray(int i) {
    return (T[]) Array.newInstance(type, i);
  }

  public T find(T t) {
    T checkT = null;
    for (Object element : array) {
      if (element != null && t.equals(element)) {
        checkT = (T) element;
        break;
      }
    }
    return checkT;
  }

  public void addAll(T[] Ts) {
    for (T T : Ts) {
      add(T);
    }
  }
}
