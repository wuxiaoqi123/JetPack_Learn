package com.welcome.jetpack_learn.ui.navigation.fg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.welcome.jetpack_learn.R
import kotlinx.android.synthetic.main.activity_bottom_nav_sample.*
import kotlinx.android.synthetic.main.fragment_sample_args.*

class SampleArgsFragment : Fragment() {

    private val args: SampleArgsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample_args, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().toolbar.title = resources.getString(R.string.title_args)
        tv_sample_args_content.text =
            if (args.argumentFlag == 0) args.argumentNormal
            else args.argumentBean.title
        btn_nav_args_jump.setOnClickListener {
            findNavController().navigate(R.id.action_argsSampleFragment_to_homeSampleFragment)
        }
    }
}