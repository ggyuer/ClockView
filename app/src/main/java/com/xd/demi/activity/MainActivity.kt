package com.xd.demi.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.xd.demi.R
import com.xd.demi.activity.MPChart.LineChartActivity
import com.xd.demi.adapter.DividerItemDecoration
import com.xd.demi.adapter.SamplesAdapter
import com.xd.demi.bean.Samples
import kotlinx.android.synthetic.main.activity_main.*
import org.joda.time.DateTime
import java.util.*


class MainActivity : Activity() {
    private var clazz = arrayOf(WaitIngActivity::class.java,TrendActivity::class.java,LoveActivity::class.java,ProduceConsumerActivity::class.java,ScrollerActivity::class.java,ViewDragHelperActivity::class.java,ScreenMatchActivity::class.java,FirstActivity::class.java, MyServiceActivity::class.java, LineChartActivity::class.java, MatrixActivity::class.java, PieChatActivity::class.java, ClockActivity::class.java, CoordinateActivity::class.java, EventActivity::class.java, ListActivity::class.java, NotifyCationActivity::class.java, ShopCarActivity::class.java, CameraActivity::class.java, EToastActivity::class.java, TimeConutDownActivity::class.java, AnimationActivity::class.java, ViewPagerActivity::class.java, DownloadActivity::class.java, RetrofitOKHttpActivity::class.java, RxJavaActivity::class.java, PercentActivity::class.java, PortfoliosActivity::class.java, WaveActivity::class.java, VideoPlayerActivity::class.java, SelfDefinedActivity::class.java, FlowLayoutActivity::class.java, InputEmojiActivity::class.java)
    private var describle = arrayOf("WaitIngActivity","TrendActivity","LoveActivity","ProducerConsumer","Scroller","ViewDragHelper","屏幕适配","Activity生命周期","MyServiceActivity","LineChartActivity","Matrix", "水果大拼盘", "时钟表盘", "坐标系", "事件监听", "多布局RecycleView列表", "通知栏事件监听", "购物车动画", "照相机", "自定义Toast", "倒计时", "动画", "ViewPager", "下载apk", "Retrofit", "RXJava", "圆环百分比", "收益走势图", "雷达波浪View", "视频播放器", "SelfDefinedActivity", "FlowLayoutActivity", "InputEmojiActivity")
    private var sampleList = ArrayList<Samples>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in describle.indices) {
            val mSample = Samples()
            mSample.description = describle[i]
            mSample.mClass = clazz[i]
            sampleList.add(mSample)
        }
        val sampleAdapter = SamplesAdapter(sampleList, this)
        sampleAdapter.openLoadAnimation()
        rcv.layoutManager = LinearLayoutManager(this)
        rcv.adapter = sampleAdapter
        rcv.addItemDecoration(DividerItemDecoration(this))
        sampleAdapter.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { adapter, _, position ->
            val sample = adapter.getItem(position) as Samples
            startActivity(Intent(this@MainActivity, sample.mClass))
        }
    }
}
