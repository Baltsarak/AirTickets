package com.baltsarak.presentation

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.baltsarak.presentation.adapter.MusicAdapter
import com.baltsarak.presentation.databinding.FragmentFirstBinding
import com.baltsarak.presentation.di.ViewModelFactory
import com.baltsarak.presentation.utils.CyrillicInputFilter
import com.baltsarak.presentation.utils.MusicItemDecoration
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

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.music_item_spacing)
        binding.rvMusic.addItemDecoration(MusicItemDecoration(spacingInPixels))

        viewModel.musicOffersLiveData.observe(viewLifecycleOwner, Observer { items ->
            adapter.submitList(items)
        })

        viewModel.getTextFromCache().observe(viewLifecycleOwner, Observer { cachedText ->
            binding.etFrom.setText(cachedText)
        })

        binding.rvMusic.adapter = adapter

        binding.etTo.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                var from = binding.etFrom.text.toString()
                if (from.isNotEmpty()) {
                    from = from[0].uppercaseChar() + from.substring(1)
                }
                viewModel.saveTextInCache(from)
                val bottomSheetFragment = ModalSearchFragment.newInstance(from)
                bottomSheetFragment.show(
                    requireActivity().supportFragmentManager,
                    bottomSheetFragment.tag
                )
            }
        }

        binding.etTo.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE
                || actionId == EditorInfo.IME_ACTION_GO
                || event?.keyCode == KeyEvent.KEYCODE_ENTER) {
                goToTickets()
                true
            } else {
                false
            }
        }

        binding.etFrom.filters = arrayOf(CyrillicInputFilter())
        binding.etTo.filters = arrayOf(CyrillicInputFilter())
    }

    private fun goToTickets() {
        val fromCity = binding.etFrom.text.toString()
        val toCity = binding.etTo.text.toString()
        val flightSelectionFragment = FlightSelectionFragment.newInstance(fromCity, toCity)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_screen_fragment_container, flightSelectionFragment)
            .commit()
    }
}

