package com.Sztomberska.utils;

import com.Sztomberska.model.User;

public class UserList {
  private User[] users=new User[10];
  private int index=0;
  public void addUser(User user){
    if(index==users.length-1){
      User[]newUsers = new User[users.length+10];
      for (int i = 0; i < users.length; i++) {
        newUsers[i]=users[i];
      }
      users=newUsers;
    }
    users[index]=user;
    index++;
  }
  public User [] getAll(){
    User [] user = new User[index];
    for (int i = 0; i < user.length; i++) {
      user[i]=users[i];
    }
    return user;
  }
  public User findUser(String login) {
    User checkUser = null;
    for (User user : users) {
      if (user != null && login.equals(user.getLogin())) {
        checkUser = user;
        break;
      }
    }
    return checkUser;
  }
}
