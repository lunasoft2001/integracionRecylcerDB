package at.ums.integracionrecylcerdb.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import at.ums.integracionrecylcerdb.modelos.Clientes;

/**
 * Created by luna-aleixos on 21.04.2016.
 */
public class DataSourceListaClientes {

    DBHelper ayudaDb;
    SQLiteDatabase db;

    public static final String [] todasColumnaslistaClientes = {
            DBHelper.ColClientes.ID,
            DBHelper.ColClientes.NOMBRE,
            DBHelper.ColClientes.DIRECCION,
            DBHelper.ColClientes.TELEFONO
    };

    public DataSourceListaClientes (Context context){
        ayudaDb = new DBHelper(context);
    }

    public void abrir(){
        db = ayudaDb.getWritableDatabase();
    }

    public void cerrar() {
        ayudaDb.close();
    }

    public List<Clientes> verListadoClientes(){

        Cursor cursor = db.query(DBHelper.Tablas.CLIENTES, todasColumnaslistaClientes, null, null, null, null, null);

        List<Clientes> listaClientes = new ArrayList<Clientes>();
        while (cursor.moveToNext()){
            Clientes clientes = new Clientes();
            clientes.setIdCliente(cursor.getInt(cursor.getColumnIndex(DBHelper.ColClientes.ID)));
            clientes.setNombre(cursor.getString(cursor.getColumnIndex(DBHelper.ColClientes.NOMBRE)));
            clientes.setDireccion(cursor.getString(cursor.getColumnIndex(DBHelper.ColClientes.DIRECCION)));
            clientes.setTelefono(cursor.getString(cursor.getColumnIndex(DBHelper.ColClientes.TELEFONO)));
            listaClientes.add(clientes);
        }

        return listaClientes;

    }
}
