package com.beyondworlds.wanandroid.home

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.beyondworlds.wanandroid.R
import com.beyondworlds.wanandroid.base.BaseFragment
import com.beyondworlds.wanandroid.home.banner.BannerInfo
import com.beyondworlds.wanandroid.home.banner.GlideImageLoader
import com.beyondworlds.wanandroid.home.recyclerview.HomeAdapter
import com.youth.banner.Banner
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment(), HomeFragmentView {
    val mHomeFragmentPresenter: HomeFragmentPresenter by lazy {
        HomeFragmentPresenter(this)
    }
    val mHomeAdapter: HomeAdapter by lazy {
        HomeAdapter(context, mDatas)
    }

    private lateinit var banner_home: Banner
    var mDatas = ArrayList<HomeInfo.DataBean.DatasBean>()
    var mImgString = ArrayList<String>()
    var mIndex = 0;
    var isRefreshIng = false
    var mHandler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    }

    override fun getHomeListSuccess(homeInfo: HomeInfo?) {
        mHandler.post {
            homeInfo?.data?.datas?.let {
                mHomeAdapter.run {
                    if (isRefreshIng) {
                        refresh_home.finishRefresh()
                        isRefreshIng = false
                        replaceData(it)
                        mIndex == 1
                        return@let
                    } else {
                        refresh_home.finishLoadMore()
                        addData(it)
                    }
                }
                mIndex++
            }
        }

    }

    override fun getHomeListFailed(errMsg: String) {
        isRefreshIng = false
        refresh_home.finishRefresh()
    }

    override fun getBannerSuccess(bannerInfo: BannerInfo?) {
        bannerInfo?.data?.let {
            for (dataBean in it) {
                mImgString.add(dataBean.imagePath)
            }
        }
        mHandler.post {
            banner_home.setImages(mImgString)
            banner_home.start()
        }
    }

    override fun getBannerFailed(errMsg: String) {
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = LayoutInflater.from(activity).inflate(R.layout.banner_home, null) as LinearLayout
        banner_home = view.findViewById(R.id.banner_home)
        view.removeAllViews()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBanner()
        initRecyclerView()
        initData()
        refresh_home.setOnRefreshListener {
            isRefreshIng = true
            mHomeFragmentPresenter.getHomeList()
        }
        refresh_home.setOnLoadMoreListener { mHomeFragmentPresenter.getHomeList(mIndex) }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            rv_home?.smoothScrollToPosition(0)
        } else {

        }
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mImgString.clear()
    }

    fun initBanner() {
        banner_home.run {
            setImageLoader(GlideImageLoader())
        }
    }

    fun initRecyclerView() {
        rv_home.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = mHomeAdapter
//            addItemDecoration(HomeItemDecoration(activity, LinearLayoutManager.VERTICAL))
        }
        mHomeAdapter.run {
            addHeaderView(banner_home)
        }
    }

    fun initData() {
        mHomeFragmentPresenter.getBanner()
        mHomeFragmentPresenter.getHomeList()
    }
}
