package com.rpm.demo.spring.learn.annotations;

import java.lang.reflect.Method;

/**
 * Created by gc-rise on 2017/8/11.
 */
public class UseTodo {
    @Todo(priority = Todo.Priority.MEDIUM, author = "Yashwant", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
    //Some business logic is written
    //But it’s not complete yet
        Class businessLogicClass = UseTodo.class;
        for(Method method : businessLogicClass.getMethods()) {
            Todo todoAnnotation = (Todo) method.getAnnotation(Todo.class);
            if (todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
            }
        }

    }


    public static void main(String[] args) {
        UseTodo todo = new UseTodo();
        todo.incompleteMethod1();
    }
}
