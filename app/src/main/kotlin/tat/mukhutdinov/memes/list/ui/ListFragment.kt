package tat.mukhutdinov.memes.list.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import tat.mukhutdinov.android.structure.StructureFragment
import tat.mukhutdinov.android.utils.autoCleared
import tat.mukhutdinov.memes.R
import tat.mukhutdinov.memes.databinding.ListBinding
import tat.mukhutdinov.memes.list.ui.boundary.ListViewModel
import tat.mukhutdinov.memes.list.ui.recycler.ListAdapter

class ListFragment : StructureFragment<ListBinding>() {

    override val viewModel: ListViewModel by viewModel()

    private var adapter: ListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupList()

        observeError()
    }

    private fun observeError() {
        viewModel.error.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.list_error_title)
                .setMessage(it)
                .setPositiveButton(R.string.list_error_retry) { _, _ -> viewModel.fetchMemes() }
                .setNegativeButton(android.R.string.cancel) { _, _ -> activity?.finish() }
                .setOnCancelListener { activity?.finish() }
                .show()
        }
    }

    private fun setupList() {
        adapter = viewModel.createAdapter()

        viewBinding.list.adapter = adapter

        viewModel.memes.observe(viewLifecycleOwner, adapter::submitList)
    }
}