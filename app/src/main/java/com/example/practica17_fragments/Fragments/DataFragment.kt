package com.example.practica17_fragments.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.practica17_fragments.Alumno.Alumno
import com.example.practica17_fragments.OnFragmentEventListener
import com.example.practica17_fragments.R


class DataFragment : Fragment(), OnClickListener {

    private var listener: OnFragmentEventListener? = null
    private lateinit var nombre: TextView
    private lateinit var apellidos: TextView
    private lateinit var dni: TextView
    private lateinit var delegado: Button
    var alumno = Alumno()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data, container, false)

        delegado = view.findViewById(R.id.btnDelegado)
        delegado.setOnClickListener(this)

        //Recojo los datos del alumno que me llegan del paquete de la main activity
        alumno = arguments?.getSerializable("Alumno") as Alumno

        dni = view.findViewById<TextView>(R.id.DNIText)
        nombre = view.findViewById<TextView>(R.id.nombreText)
        apellidos = view.findViewById<TextView>(R.id.apellidosText)

        //Seteo los campos donde se mostrarán los datos de los Alumnos
        if (arguments != null) {
            dni.setText(getString(R.string.dniFINAL) + alumno.dni)
            nombre.setText(getString(R.string.nombrefinal) + alumno.nombre)
            apellidos.setText(getString(R.string.apellidosFinal) + alumno.apellidos)
        }

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Paso la referencia del listener de la actividad
        if (context is OnFragmentEventListener) {
            listener = context as OnFragmentEventListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnDelegado -> {
                listener?.let {
                    listener!!.onFragmentEvent(alumno.nombre)
                }
            }
        }
    }


}
