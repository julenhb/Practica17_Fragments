package com.example.practica17_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.practica17_fragments.Alumno.Alumno
import com.example.practica17_fragments.Fragments.DataFragment
import com.example.practica17_fragments.Fragments.ImageFragment

class MainActivity : AppCompatActivity(), OnClickListener, OnFragmentEventListener {

    private lateinit var spinner : Spinner
    private lateinit var datos : Button
    private lateinit var foto : Button
    private lateinit var delegadoTexto : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        datos = findViewById(R.id.btnDatos)
        foto = findViewById(R.id.btnFoto)
        spinner = findViewById(R.id.spinnerAlumnos)
        delegadoTexto = findViewById(R.id.delegadoText)
        val arrayAlumnos = ArrayList<Alumno>()

        val a1 = Alumno("Julen", "Hernández Berja", "71205721K", R.drawable.chico1)
        val a2 = Alumno("Natalia", "Ajo Hernández", "54846584O", R.drawable.chica1)
        val a3 = Alumno("Itachi", "Uchiha", "854120525T", R.drawable.chico2)
        val a4 = Alumno("Fara", "Joselez Josez", "76241589I", R.drawable.chica2)

        arrayAlumnos.add(a1)
        arrayAlumnos.add(a2)
        arrayAlumnos.add(a3)
        arrayAlumnos.add(a4)



        datos.setOnClickListener(this)
        foto.setOnClickListener(this)

        val adaptadorAlumnos = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, arrayAlumnos)

        spinner.adapter = adaptadorAlumnos
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.btnDatos ->{
                //Creo un paquete
                val bundle = Bundle()
                //Elijo el alumno del Spinner que voy a pasar al fragmento
                val alumno = spinner.selectedItem as Alumno

                val fragmentManager = supportFragmentManager

                /*Crear una transaccion*/
                val fragmentTransaction = fragmentManager.beginTransaction()
                /*Crear instancia del fragmento a cargar*/

                var miFragmento : Fragment? = null
                miFragmento = DataFragment()

                //Meto al alumno en el bundle
                bundle.putSerializable("Alumno",alumno)

                //Paso al fragmento como argumentos el paquete
                miFragmento.arguments  = bundle

                fragmentTransaction.replace(R.id.containerFragments, miFragmento)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            R.id.btnFoto ->{
                //Creo un paquete
                val bundle = Bundle()
                //Elijo el alumno del Spinner que voy a pasar al fragmento
                val alumno = spinner.selectedItem as Alumno

                val fragmentManager = supportFragmentManager
                /*Crear una transaccion*/
                val fragmentTransaction = fragmentManager.beginTransaction()
                /*Crear instancia del fragmento a cargar*/
                var miFragmento : Fragment? = null
                miFragmento = ImageFragment()

                /*Aquí, a diferencia de antes, lo que me interesa recoger es el
                 id de la imagen para pasarla al fragmento 2, así que me llevo sólo en imageId(Int)
                */
                bundle.putInt(resources.getString(R.string.image), alumno.imageId)
                miFragmento.arguments  = bundle

                fragmentTransaction.replace(R.id.containerFragments, miFragmento)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }

    //IMPORTANTE: Aquí le pido lo que quiero recbir de los fragments, en este caso es el nombre(String) de un Alumno(Objeto)
    //Esto viene marcado por la interfaz anteriormente
    override fun onFragmentEvent(nombre: String) {
        delegadoTexto.setText(nombre)

    }

}