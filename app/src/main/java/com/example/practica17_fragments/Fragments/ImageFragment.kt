package com.example.practica17_fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.practica17_fragments.R


class ImageFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Carga el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_image, container, false)

        // Si ha recibido argumentos
        arguments?.let {
            // Obtiene el id de la imagen
            val imageId = requireArguments().getInt(resources.getString(R.string.image))
            // Obtiene la vista de imagen
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            // Carga la imagen en la vista
            imageView.setImageDrawable(context?.getDrawable(imageId))
        }
        return view
    }


}