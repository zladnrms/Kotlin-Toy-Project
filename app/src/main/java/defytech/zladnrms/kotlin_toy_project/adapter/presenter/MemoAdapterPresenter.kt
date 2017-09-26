package defytech.zladnrms.kotlin_toy_project.adapter.presenter

import android.content.Context
import defytech.zladnrms.kotlin_toy_project.adapter.view.MemoAdapterView
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepository
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepositoryModel
import defytech.zladnrms.kotlin_toy_project.presenter.BasePresenter
import defytech.zladnrms.kotlin_toy_project.view.`interface`.BaseView
import defytech.zladnrms.kotlin_toy_project.view.`interface`.HomeView

/**
 * Created by kim on 2017-09-14.
 */
class MemoAdapterPresenter : BasePresenter {

    private var view: MemoAdapterView? = null
    private var repo: LocalDataRepositoryModel? = null

    override fun attachView(view: BaseView) {
        this.view = view as MemoAdapterView
        this.repo = LocalDataRepository.getInstance()
    }

    override fun detachView(view: BaseView) {
        this.view = view as MemoAdapterView
        this.view = null
    }

    fun delData(context : Context, id : Int) {
        this.repo?.delData(context, id)
    }
}