package com.example.app_test_kpit

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.app_test_kpit.databinding.FragmentStartBinding
import org.example.KPITApi
import java.io.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding: FragmentStartBinding? = null
    private var counter: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            // Set up the button click listeners\\
            counter = counterlabel
            button.setOnClickListener {
                openFileChooser()
            }
        }
    }

    fun openFileChooser(){
        val intent = Intent()
            .setType("*/*")
            .setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == RESULT_OK) {
             readFileWordsCount(data?.data!!)
        }
    }

    fun readFileWordsCount(path: Uri){
        try {
            // i'm not sure about this part
            // here what i'm doing it, because i'm not able to get path for file from uri
            // i created temp file with content of selected file, them passing this temp file path to api.
            var inputStream1 = context?.getContentResolver()?.openInputStream(path)
            val outputDir = context?.cacheDir // context being the Activity pointer
            val outputFile = File.createTempFile("temp", ".extension", outputDir)
            inputStream1?.copyTo(FileOutputStream(outputFile));

            // consume our api to count file words number
            val wordCounter =  KPITApi()
            val count =  wordCounter.countFileWords(outputFile.path)
            // show result to user with Toast and update label
            counter?.setText("File have " + count + " word");
            Toast.makeText(context, "Words " + count, Toast.LENGTH_SHORT).show();
        } catch (e: IOException) {
            counter?.setText(e.toString())
        }
    }
}