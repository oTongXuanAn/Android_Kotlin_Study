package com.example.framgiatongxuanan.android_kotlin_st.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.framgiatongxuanan.android_kotlin_st.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class BlankFragment : Fragment() {
   private var username : String=""
    var password :String = ""

    companion object {
        val TAG: String = BlankFragment::class.java.simpleName
        fun newInstance() = BlankFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity.title = "Home"
        username = this.getArguments().getString("username").toString()
        password = this.getArguments().getString("password").toString()
        Log.e(TAG, "username: " + username + " " + password)
        return inflater!!.inflate(R.layout.fragment_home, container, false)

    }

}
