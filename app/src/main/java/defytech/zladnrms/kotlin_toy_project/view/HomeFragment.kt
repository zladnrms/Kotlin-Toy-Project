package defytech.zladnrms.kotlin_toy_project.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import defytech.zladnrms.kotlin_toy_project.R
import defytech.zladnrms.kotlin_toy_project.adapter.view.MemoListAdapterKt
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.presenter.HomePresenter
import defytech.zladnrms.kotlin_toy_project.presenter.MainPresenter
import defytech.zladnrms.kotlin_toy_project.view.`interface`.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by kim on 2017-09-20.
 */
class HomeFragment : Fragment(), HomeView {

    private var presenter : HomePresenter? = null
    private var adapter : MemoListAdapterKt? = null

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        presenter = HomePresenter()
        presenter?.attachView(this)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* 빨간 줄 뜨는데 다시 똑같이 쓰면 안 남 */
        rvMemoList.layoutManager = LinearLayoutManager(activity)
        rvMemoList.hasFixedSize()
        adapter = MemoListAdapterKt(activity, ArrayList<MemoDataInfo>())
        rvMemoList.adapter = adapter

        btnWrite.setOnClickListener {
            (activity as MainActivity).switchFragment(WriteFragment(), "write")
        }
    }

    /* onResume -> getLocalData -> getDataArr -> getData */
    override fun onResume() {
        super.onResume()
        presenter!!.onResume()
    }

    override fun getLocalData() {
        presenter?.getLocalData(activity)
    }

    override fun getDataArr(memoArr: ArrayList<String>) {
        presenter?.jsonDecode(memoArr)
    }

    override fun getData(memoDataInfo: MemoDataInfo) {
        adapter?.add(memoDataInfo)
        adapter?.refresh()
    }

    override fun refresh() {
        adapter?.refresh()
    }

    override fun clear() {
        adapter?.clear()
    }
}