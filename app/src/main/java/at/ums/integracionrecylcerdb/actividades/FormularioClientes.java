package at.ums.integracionrecylcerdb.actividades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import at.ums.integracionrecylcerdb.R;
import at.ums.integracionrecylcerdb.database.DBHelper;
import at.ums.integracionrecylcerdb.database.DataSourceListaClientes;

public class FormularioClientes extends AppCompatActivity {

    private SQLiteDatabase db;
    DataSourceListaClientes mDataSourceListaClientes;

    private TextView idCliente;
    private EditText nombre;
    private EditText direccion;
    private EditText telefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_clientes);


        //Asociamos elementos variables a elementos de la vista
        idCliente = (TextView) findViewById(R.id.tvIdCliente);
        nombre = (EditText) findViewById(R.id.etNombre);
        direccion = (EditText) findViewById(R.id.etDireccion);
        telefono = (EditText) findViewById(R.id.etTelefono);

        //Rellenamos los campos
        Intent intento = getIntent();

        Bundle bundle = intento.getExtras();
        if(bundle != null){
            idCliente.setText(bundle.getString("idCliente"));
            nombre.setText(bundle.getString("nombre"));
            direccion.setText(bundle.getString("direccion"));
            telefono.setText(bundle.getString("telefono"));

        }




        //Abrimos la BD en modo escritura
        mDataSourceListaClientes = new DataSourceListaClientes(this);
        mDataSourceListaClientes.abrir();

        //Codigo para el onClickListener
        findViewById(R.id.btCancelar).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btEliminar).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btGuardar).setOnClickListener(mGlobal_onClickListener);

    }

    //Intents para cualquier botón de la actividad
    final View.OnClickListener mGlobal_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btCancelar:
                    finish();
                    break;
                case R.id.btEliminar:
                    Eliminar();
                    break;
                case R.id.btGuardar:
                    Actualizar();
                    break;
            }
        }
    };

    //Este método iría aquí o mejor en DataSource??
    public void Eliminar() {

        int id = Integer.parseInt(idCliente.getText().toString());
        db.delete(DBHelper.Tablas.CLIENTES,DBHelper.ColClientes.ID + "=" + id, null);

    }

    //Este método iría aquí o mejor en DataSource??
    public void Actualizar() {
        //Recuperamos los campos de texto
        int idActual = Integer.parseInt(idCliente.getText().toString());
        String nombreTxt = nombre.getText().toString();
        String direccionTxt = direccion.getText().toString();
        String telefonoTxt = telefono.getText().toString();

        //metodo Update
        ContentValues actualizar = new ContentValues();
        actualizar.put(DBHelper.ColClientes.NOMBRE, nombreTxt);
        actualizar.put(DBHelper.ColClientes.DIRECCION, direccionTxt);
        actualizar.put(DBHelper.ColClientes.TELEFONO,telefonoTxt);

        db.update(DBHelper.Tablas.CLIENTES, actualizar, DBHelper.ColClientes.ID +"="+idActual, null);

    }



}
