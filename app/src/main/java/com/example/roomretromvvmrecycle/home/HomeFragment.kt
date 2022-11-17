package com.example.roomretromvvmrecycle.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomretromvvmrecycle.HomeViewModel
import com.example.roomretromvvmrecycle.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeAdapter = HomeAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeFoods()
        showProgressBar()

    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {

            adapter = homeAdapter
        }

    }


    private fun observeFoods() {

        homeViewModel.observeFoods().observe(viewLifecycleOwner) {
            homeAdapter.setFoods(it)
            hideProgressBar()
        }


    }


    private fun showProgressBar() {

        binding.mProgressBar.visibility = View.VISIBLE

    }

    private fun hideProgressBar() {

        binding.mProgressBar.visibility = View.GONE

    }

}










