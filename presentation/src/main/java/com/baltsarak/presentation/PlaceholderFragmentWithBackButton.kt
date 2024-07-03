package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlaceholderFragmentWithBackButton : Fragment() {
    companion object {
        private const val ARG_TEXT = "arg_text"

        fun newInstance(text: String): PlaceholderFragmentWithBackButton {
            val fragment = PlaceholderFragmentWithBackButton()
            val args = Bundle()
            args.putString(ARG_TEXT, text)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_placeholder_with_back_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = arguments?.getString(ARG_TEXT)
        view.findViewById<TextView>(R.id.tv_placeholder).text = text

        view.findViewById<FrameLayout>(R.id.btn_back).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}