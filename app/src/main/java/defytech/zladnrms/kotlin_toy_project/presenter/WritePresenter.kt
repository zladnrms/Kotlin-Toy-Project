package defytech.zladnrms.kotlin_toy_project.presenter

import android.content.Context
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepository
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepositoryModel
import defytech.zladnrms.kotlin_toy_project.view.`interface`.BaseView
import defytech.zladnrms.kotlin_toy_project.view.`interface`.WriteView

/**
 * Created by kim on 2017-09-14.
 */
class WritePresenter : BasePresenter {

    private var view: WriteView? = null
    private var repo: LocalDataRepositoryModel? = null

    override fun attachView(view: BaseView) {
        this.view = view as WriteView
        this.repo = LocalDataRepository.getInstance()
    }

    override fun detachView(view: BaseView) {
        this.view = view as WriteView
        this.view = null
    }

    fun addData(context : Context, title : String, content : String) {
        this.repo?.insert(context!!,  title!!, content!!)
    }

}