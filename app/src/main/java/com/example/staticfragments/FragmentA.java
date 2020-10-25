package com.example.staticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class FragmentA extends Fragment {
    private static final String TAG = "StaticFragment" ;
    private EditText edtMessage;
    private SeekBar skSize;
    private Button btAction;
    private OnSetMessageSizeListener listener;

    /**
     * Esta interfaz servirá de contrato entre el Fragment y su clase contenedora (Activity)
     */
    public interface OnSetMessageSizeListener{
        void onSetMessageSize(String message,int size);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener=(OnSetMessageSizeListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() +" must implement OnSetMessageSize");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"FragmentA -> onCreateView()");
        return inflater.inflate(R.layout.fragmenta,root,false);
    }

    /**
     * Este método se puede utilizar para inicializar los componentes o widget
     * porque la vista ya se ha inflado y no es null
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        edtMessage= view.findViewById(R.id.edtMessage);
        skSize=view.findViewById(R.id.skbSize);
        btAction=view.findViewById(R.id.btAction);
        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSetMessageSize(edtMessage.getText().toString(),skSize.getProgress());
            }
        });
        Log.d(TAG,"FragmentA -> onViewCreated()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
        Log.d(TAG,"FragmentA -> onDetach()");
    }

}
