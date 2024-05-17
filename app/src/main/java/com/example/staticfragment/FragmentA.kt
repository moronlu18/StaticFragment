package com.example.staticfragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.staticfragment.databinding.FragmentaBinding
import com.example.staticfragment.databinding.FragmentbBinding

class FragmentA : Fragment() {
    //Create Databinding
    private var _binding: FragmentaBinding? = null
    private val binding get() = _binding!!

    private var listener: OnSetMessageSizeListener? = null

    /**
     * Esta interfaz servirá de contrato entre el Fragment y su clase contenedora (Activity)
     */
    interface OnSetMessageSizeListener {
        fun onSetMessageSize(message: String?, size: Int)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnSetMessageSizeListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnSetMessageSize")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        root: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(FragmentA.TAG, "FragmentA -> onCreateView()")
        _binding = FragmentaBinding.inflate(inflater, root, false)
        return binding.root
    }

    /**
     * Este método se puede utilizar para inicializar los componentes o widget
     * porque la vista ya se ha inflado y no es null
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        binding.btAction.setOnClickListener(View.OnClickListener {
            listener!!.onSetMessageSize(
                binding.edtMessage.getText().toString(), binding.skbSize.progress
            )
        })
        Log.d(TAG, "FragmentA -> onViewCreated()")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        Log.d(TAG, "FragmentA -> onDetach()")
    }

    companion object {
        private const val TAG = "StaticFragment"
    }
}
