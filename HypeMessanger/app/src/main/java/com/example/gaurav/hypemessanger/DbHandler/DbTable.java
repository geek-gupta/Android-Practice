package com.example.gaurav.hypemessanger.DbHandler;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.gaurav.hypemessanger.Model.AuthenticationModel;
import com.example.gaurav.hypemessanger.Model.DataModel;
import com.example.gaurav.hypemessanger.Model.GroupModel;
import com.example.gaurav.hypemessanger.Model.UserModel;

/**
 * Created by gaurav on 7/23/2017.
 */

public class DbTable {


    public interface UserColumns {
        String id = " id ";
        String name = " name ";
        String phone = " phone ";
        String email = " email ";
    }

    public interface GroupColumns {
        String id = " id ";
        String groupname = " groupname ";
        String count = " count ";
    }

    public interface DataColumns {
        String id = "id";
        String timeStamp = "timestamp";
        String senderId = "senderid";
        String senderName = "sendername";
        String data = "data";
    }

    public interface AuthenticationColumns {
        String userName = "username";
        String password = "password";
        String id = "id";
    }


    public interface DbConstants {
        String TEXT = " text ";
        String LBR = " ( ";
        String RBR = " ) ";
        String COMMA = " , ";
        String TIMESTAMP = "timedate";
    }

    public interface TableName {
        String USER_TABLE = " user ";
        String AUTHENTICATION_TABLE = " authenticationtable ";
        String DATA_TABLE = " datatable ";
        String GROUP_TABLE = " grouptable ";
    }

    public static String CMD_CREATE_USER_TABLE = "CREATE TABLE " + TableName.USER_TABLE + DbConstants.LBR +
            UserColumns.id + DbConstants.TEXT + " PRIMARY KEY " + " NOT NULL " + " AUTOINCREMENT " + DbConstants.COMMA +
            UserColumns.name + DbConstants.TEXT + DbConstants.COMMA +
            UserColumns.phone + DbConstants.TEXT + DbConstants.COMMA +
            UserColumns.email + DbConstants.TEXT + DbConstants.RBR + ";";


    public static String CMD_CREATE_GROUP_TABLE = " CREATE TABLE " + TableName.GROUP_TABLE + DbConstants.LBR +
            GroupColumns.id + DbConstants.TEXT + " PRIMARY KEY " + " NOT NULL " + " AUTOINCREMENT " + DbConstants.COMMA +
            GroupColumns.groupname + DbConstants.TEXT + DbConstants.COMMA +
            GroupColumns.count + " numeric " + DbConstants.RBR + ";";

    public static String CMD_CREATE_AUTHENTICATION_TABLE = "CREATE TABLE " + TableName.AUTHENTICATION_TABLE + DbConstants.LBR +
            AuthenticationColumns.id + DbConstants.TEXT + "PRIMARY KEY" + "NOT NULL" + " AUTOINCREMENT " + DbConstants.COMMA +
            AuthenticationColumns.password + DbConstants.TEXT + DbConstants.COMMA +
            AuthenticationColumns.userName + DbConstants.TEXT + DbConstants.RBR + ";";

    public static String CMD_CREATE_DATA_TABLE = "CREATE TABLE" + TableName.DATA_TABLE + DbConstants.LBR +
            DataColumns.id + DbConstants.TEXT + " PRIMARY KEY " + " NOT NULL " + " AUTOINCREMENT " + DbConstants.COMMA +
            DataColumns.data + DbConstants.TEXT + DbConstants.COMMA +
            DataColumns.senderId + DbConstants.TEXT + DbConstants.COMMA +
            DataColumns.timeStamp + DbConstants.TIMESTAMP + ";";

    public static void insertDataTable(SQLiteDatabase db, DataModel dataModel) {
        ContentValues values = new ContentValues();
        values.put(DataColumns.data, dataModel.getData());
        values.put(DataColumns.senderId, dataModel.getSenderId());
        values.put(DataColumns.senderName, dataModel.getSenderName());
        values.put(DataColumns.timeStamp, dataModel.getTimeStamp());
        db.insert(TableName.DATA_TABLE, null, values);
    }

    public static void insertUserTable(SQLiteDatabase db, UserModel userModel) {
        ContentValues values = new ContentValues();
        values.put(UserColumns.name, userModel.getName());
        values.put(UserColumns.email, userModel.getEmail());
        values.put(UserColumns.phone, userModel.getPhone());
        db.insert(TableName.USER_TABLE, null, values);
    }

    public static void insertAuthenticationTable(SQLiteDatabase db, AuthenticationModel authenticationModel) {
        ContentValues values = new ContentValues();
        values.put(AuthenticationColumns.password, authenticationModel.getPassword());
        values.put(AuthenticationColumns.userName, authenticationModel.getUserName());
        db.insert(TableName.AUTHENTICATION_TABLE, null, values);
    }

    public static void insertGroupTable(SQLiteDatabase db, GroupModel groupModel) {
        ContentValues values = new ContentValues();
        values.put(GroupColumns.groupname, groupModel.getGroupName());
        values.put(GroupColumns.count, groupModel.getMemberCount());
        db.insert(TableName.GROUP_TABLE, null, values);
    }

}
