package defytech.zladnrms.kotlin_toy_project.presenter

import android.content.Context
import android.widget.Toast
import com.orhanobut.logger.Logger
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepository
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepositoryModel
import defytech.zladnrms.kotlin_toy_project.view.`interface`.BaseView
import defytech.zladnrms.kotlin_toy_project.view.`interface`.MainView
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

/**
 * Created by kim on 2017-09-14.
 */
class MainPresenter : BasePresenter {

    private var view: MainView? = null
    private var repo: LocalDataRepositoryModel? = null

    override fun attachView(view: BaseView) {
        this.view = view as MainView
        this.repo = LocalDataRepository.getInstance()
    }

    override fun detachView(view: BaseView) {
        this.view = view as MainView
        this.view = null
    }
}