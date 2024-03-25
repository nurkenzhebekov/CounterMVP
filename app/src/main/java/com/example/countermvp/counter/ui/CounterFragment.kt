package com.example.countermvp.counter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.countermvp.counter.view.CounterView
import com.example.countermvp.databinding.FragmentCounterBinding
import com.example.countermvp.model.Injector

class CounterFragment : Fragment(), CounterView {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    private var presenter = Injector.getPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCounterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btIncrement.setOnClickListener {
                presenter.increment()
            }
            btDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun setColor(colorResId: Int, count: Int) {
        val color = ContextCompat.getColor(requireContext(), colorResId)
        binding.tvResult.setTextColor(color)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}