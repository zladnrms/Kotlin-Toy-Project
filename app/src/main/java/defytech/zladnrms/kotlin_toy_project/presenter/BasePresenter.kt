package defytech.zladnrms.kotlin_toy_project.presenter

import defytech.zladnrms.kotlin_toy_project.view.`interface`.BaseView

/**
 * Created by kim on 2017-09-14.
 */
interface BasePresenter {
    fun attachView(view: BaseView) {}

    fun detachView(view: BaseView) {}
}