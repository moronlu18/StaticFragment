package com.example.staticfragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
 class MainActivity : AppCompatActivity(), FragmentA.OnSetMessageSizeListener {
    private val TAG = "StaticFragment"
    private var fragmentb: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentb = supportFragmentManager.findFragmentById(R.id.fragmentb)
        Log.d(TAG, "Activity -> onCreate()")
    }

    /**
     * Método que modifica el texto y el tamaño de texto del TextView del
     * FragmentB
     * @param message
     * @param size
     */
    override fun onSetMessageSize(message: String?, size: Int) {
        //Toast.makeText(this,"Muestra mensaje:"+message,Toast.LENGTH_SHORT).show();
        //La Activity puede realizar cualquier operación o comprobación de los datos antes
        //de pasárselo al Fragment --> Clase Controladora
        (fragmentb as FragmentB?)!!.setMessageSize(message, size)
    }

    /************************************************************
     * Métodos que se llaman para guardar el estado de la Activity
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState!!)
        Log.d(TAG, "Activity -> onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState!!)
        Log.d(TAG, "Activity -> onRestoreInstanceState()")
    }

    /** */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity -> onDestroy()")
    }
}
