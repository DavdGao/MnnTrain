package com.example.mnntrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mnntrain.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'mnntrain' library on application startup.
    static {
        System.loadLibrary("mnntrain");
        System.loadLibrary("MNN");
        System.loadLibrary("MNNTrain");
        System.loadLibrary("MNN_Express");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'mnntrain' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}