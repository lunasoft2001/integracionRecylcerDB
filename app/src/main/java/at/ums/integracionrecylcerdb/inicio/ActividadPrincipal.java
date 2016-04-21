package at.ums.integracionrecylcerdb.inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.ums.integracionrecylcerdb.actividades.ListaClientes;
import at.ums.integracionrecylcerdb.R;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }

    /**
     * metodos para abrir las distintas actividades
     *
     */

    public void botonListaClientes(View v){
        Intent intento = new Intent(this, ListaClientes.class);
        startActivity(intento);

    }
}
