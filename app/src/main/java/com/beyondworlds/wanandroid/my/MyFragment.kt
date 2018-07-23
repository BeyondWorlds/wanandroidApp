package com.beyondworlds.wanandroid.my


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 */
class MyFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_my, container, false)
    }

}
