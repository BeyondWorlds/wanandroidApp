package com.beyondworlds.wanandroid.knowledge

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_type.*

/**
 * A simple [Fragment] subclass.
 */
class TypeFragment : BaseFragment(), TypeFragmentView {
    private val mTypeFragmentPresenter: TypeFragmentPresenter by lazy {
        TypeFragmentPresenter(this)
    }
    private val mTypeAdapter: TypeAdapter by lazy {
        TypeAdapter(context, mDatas)
    }
    private var mDatas = ArrayList<KnowledgeInfo.DataBean>()
    private var mHandler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }

    override fun getTreeListSuccess(data: List<KnowledgeInfo.DataBean>?) {
        mHandler.post {
            data?.let {
                mDatas.clear()
                mDatas.addAll(data)
                mTypeAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getTreeListFailed(err: String) {
        Toast.makeText(context, err, Toast.LENGTH_LONG).show()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_type, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        initData()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            rv_type_first?.smoothScrollToPosition(0)
        } else {

        }
    }
    fun initRecyclerView() {
        rv_type_first.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = mTypeAdapter
        }
    }

    fun initData() {
        mTypeFragmentPresenter.getTreeList()
    }
}