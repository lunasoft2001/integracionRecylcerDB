package at.ums.integracionrecylcerdb.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import at.ums.integracionrecylcerdb.database.DataSourceListaClientes;
import at.ums.integracionrecylcerdb.database.Datos;
import at.ums.integracionrecylcerdb.R;
import at.ums.integracionrecylcerdb.adaptadores.ListaClientesAdapter;
import at.ums.integracionrecylcerdb.modelos.Clientes;

public class ListaClientes extends AppCompatActivity {


    /*
    Declarar instancias globales
     */
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;


    /*
    Variables SOLO para SQLite
     */
    DataSourceListaClientes mDataSourceListaClientes;
    private List<Clientes> mClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_clientes);

        /*
        Codigo para obtener los datos en la clase datos
         */
        // /List items = new Datos().getItems();

        /*
        Codigo para obtenrer los datos de la DB
         */
        mDataSourceListaClientes = new DataSourceListaClientes(this);
        mDataSourceListaClientes.abrir();

        mClientes = mDataSourceListaClientes.verListadoClientes();



        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        // Crear un nuevo adaptador

        //adapter = new ListaClientesAdapter(items);//para la clase Datos
        adapter = new ListaClientesAdapter(mClientes); //para el SQLite
        recycler.setAdapter(adapter);





    }
}
