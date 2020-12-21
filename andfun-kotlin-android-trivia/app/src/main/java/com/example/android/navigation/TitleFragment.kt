package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val biniding: FragmentTitleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false)
        setHasOptionsMenu(true)

        // 익명 함수
        biniding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_gameFragment)
        }

            /** 네비게이션 컨트롤러를 이용하여 프래그먼트들의 이동 코드를 구현
             * Navigation.findNavController(view).navigate(R.id.action_titleFragment2_to_gameFragment)
             * Navigation.findNavController 를 아래 코드로 대체 가능
             * view.findNavController().navigate(R.id.action_titleFragment2_to_gameFragment)
             * Navigation은 onClickListener를 생성 할 수 있음
             * 위 익명함수는 다음으로 대체 할 수 있음
             */

        // 대체 함수
        biniding.playButton.setOnClickListener {v : View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragment2ToGameFragment())


        }






        return biniding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}