package com.example.user.theproject.model.backend;

import android.content.Context;

/**
 * Created by user on 16/11/2017.
 */

public final class DBManagerFactory
{
    public static DB_manager instance = null;

    public static String mode = "lists";

    public final static DB_manager getInstance()
    {
        if (instance == null)
        //    instance = new com.example.user.theproject.model.datasource.List_DBManager();
        instance = new com.example.user.theproject.model.datasource.MySQL_DBManager();
        return instance;
    }


}
