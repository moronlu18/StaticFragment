package com.example.staticfragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.staticfragment.databinding.FragmentbBinding

class FragmentB : Fragment() {
    //Create Databinding
    private var _binding: FragmentbBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FragmentB -> onCreate()")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        root: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "FragmentB -> onCreateView()")
        _binding = FragmentbBinding.inflate(inflater, root, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FragmentB -> onViewCreated()")
    }


    /**
     * Método que actualiza el texto y tamaño en el Textview de la interfaz
     *
     * @param message
     * @param size
     */
    fun setMessageSize(message: String?, size: Int) {
        binding.tvMessage.text = message
        binding.tvMessage.textSize = size.toFloat()
    }

    /**
     * Este método guarda/salvar el estado dinámico del Fragment dentro del
     * objeto Bundle
     *
     * @param outState
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putFloat(
            SIZE,
            binding.tvMessage!!.textSize / getResources().getDisplayMetrics().scaledDensity
        ) //Convert px to sp
        outState.putString(MESSAGE, binding.tvMessage!!.text.toString())
        Log.d(TAG, "FragmentB -> onSaveInstanceState()")
    }

    /**
     * Método que restaura el estado del Fragment si ha sido reiniciado
     * después de un cambio de configuración.
     * 1. Se llama siempre con lo cual hay que comprobar si es en la creación o
     * se ha restaurado (savedInstanceState != null)
     * 2. Hay que guardar el texto ya que tvMessage se ha inicializado a
     * traves del método setText no porque el usuario haya introducido datos
     *
     * @param savedInstanceState
     */
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            binding.tvMessage.text = savedInstanceState.getString(MESSAGE)
            binding.tvMessage.textSize = savedInstanceState.getFloat(SIZE)
        }
        Log.d(TAG, "FragmentB -> onViewStateRestored()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "FragmentB -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FragmentB -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FragmentB -> onDestroy()")
        _binding = null
    }

    companion object {
        private const val TAG = "StaticFragment"
        private const val SIZE = "size"
        private const val MESSAGE = "message"
    }
}
