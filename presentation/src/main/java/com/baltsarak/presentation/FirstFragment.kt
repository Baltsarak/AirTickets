package com.baltsarak.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baltsarak.presentation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var adapter: MusicAdapter

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentFirstBinding is null")

    private val items = listOf(
        MusicOffer(R.drawable.flame, "Die Antwoord", "Будапешт", "от 22 264 ₽"),
        MusicOffer(R.drawable.defaultball, "Socrat & Lera", "Санкт-Петербург", "от 2 390 ₽")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = MusicAdapter()
        adapter.submitList(items)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.rvMusic.adapter = adapter
        return binding.root
    }
}