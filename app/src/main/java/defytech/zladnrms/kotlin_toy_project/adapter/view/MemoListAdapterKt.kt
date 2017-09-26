package defytech.zladnrms.kotlin_toy_project.adapter.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import defytech.zladnrms.kotlin_toy_project.R
import defytech.zladnrms.kotlin_toy_project.adapter.model.MemoDataModel
import defytech.zladnrms.kotlin_toy_project.adapter.presenter.MemoAdapterPresenter
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepositoryModel
import kotlinx.android.synthetic.main.recyclerview_memolist2.view.*

/**
 * Created by kim on 2017-09-16.
 */
class MemoListAdapterKt(var context: Context, var lists : ArrayList<MemoDataInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), MemoDataModel, MemoAdapterView {

    private var presenter : MemoAdapterPresenter? = null

    init {
        Logger.t("MEMOLISTADAPTERKT").d("init")
        presenter = MemoAdapterPresenter()
        presenter?.attachView(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var v = LayoutInflater.from(context).inflate(R.layout.recyclerview_memolist2, parent, false)

        return Item(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder?.itemView?.tv_title?.text = lists[position].title
        holder?.itemView?.tv_content?.text = lists[position].content
        holder?.itemView?.setOnClickListener {
            presenter?.delData(context, lists[position]._id)
            remove(position)
            refresh()
        }
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(_list: String) {
            itemView.tv_title.text = _list
        }
    }

    override open fun refresh() {
        notifyDataSetChanged()
    }

    override fun add(memoDataInfo: MemoDataInfo) {
        lists.add(memoDataInfo)
    }

    override fun clear() {
        lists.clear()
    }

    override fun remove(position: Int) {
        lists.removeAt(position)
    }
}