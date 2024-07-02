package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.baltsarak.presentation.adapter.MusicAdapter
import com.baltsarak.presentation.databinding.FragmentFirstBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.baltsarak.presentation.viewModels.FirstScreenViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FirstFragment : Fragment() {

    private lateinit var adapter: MusicAdapter

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentFirstBinding is null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = viewModelFactory.create(FirstScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MusicAdapter()
        binding.rvMusic.adapter = adapter

        viewModel.musicOffersLiveData.observe(viewLifecycleOwner, Observer { items ->
            adapter.submitList(items)
        })

        binding.rvMusic.adapter = adapter
        binding.etTo.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val bottomSheetFragment = ModalSearchFragment()
                bottomSheetFragment.show(
                    requireActivity().supportFragmentManager,
                    bottomSheetFragment.tag
                )
            }
        }
    }
}

