package com.example.staticfragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.staticfragment.databinding.FragmentbBinding
import com.example.staticfragment.databinding.FragmentcBinding

class FragmentC : Fragment() {

    //Create Databinding
    private var _binding: FragmentcBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        root: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "FragmentC -> onCreateView()")
        _binding = FragmentcBinding.inflate(inflater, root, false)
        return binding.root
    }

    /**
     * Este método se puede utilizar para inicializar los componentes o widget
     * porque la vista ya se ha inflado y no es null
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val html: String = getResources().getString(R.string.aboutus)
        binding.webAbout.loadData(html, "text/html", "UTF-8")
        Log.d(TAG, "FragmentC -> onViewCreated()")
    }

    companion object {
        private const val TAG = "StaticFragment"
    }
}
