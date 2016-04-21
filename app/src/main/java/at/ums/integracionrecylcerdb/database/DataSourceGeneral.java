package at.ums.integracionrecylcerdb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by luna-aleixos on 21.04.2016.
 */
public class DataSourceGeneral {

    DBHelper ayudaDb;
    SQLiteDatabase db;


    public DataSourceGeneral(Context context){
        ayudaDb = new DBHelper(context);
    }

    public void abrir(){
        db = ayudaDb.getWritableDatabase();
    }

    public void cerrar(){
        ayudaDb.close();
    }

}
