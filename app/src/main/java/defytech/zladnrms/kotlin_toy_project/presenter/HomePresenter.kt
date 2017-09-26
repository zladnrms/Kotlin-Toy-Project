package defytech.zladnrms.kotlin_toy_project.presenter

import android.content.Context
import com.orhanobut.logger.Logger
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepository
import defytech.zladnrms.kotlin_toy_project.model.LocalDataRepositoryModel
import defytech.zladnrms.kotlin_toy_project.view.`interface`.BaseView
import defytech.zladnrms.kotlin_toy_project.view.`interface`.HomeView
import defytech.zladnrms.kotlin_toy_project.view.`interface`.MainView
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

/**
 * Created by kim on 2017-09-14.
 */
class HomePresenter : BasePresenter {

    private var view: HomeView? = null
    private var repo: LocalDataRepositoryModel? = null

    override fun attachView(view: BaseView) {
        this.view = view as HomeView
        this.repo = LocalDataRepository.getInstance()
    }

    override fun detachView(view: BaseView) {
        this.view = view as HomeView
        this.view = null
    }

    fun onResume() {
        this.view?.clear();
        this.view?.getLocalData()
    }

    fun getLocalData(context: Context) {
        this.view!!.getDataArr(repo!!.getData(context))
    }

    fun jsonDecode(memoArr: ArrayList<String>) {

        if (memoArr.size > 0) {

            try {
                for (i in memoArr.indices) {
                    val obj = JSONObject(memoArr[i]) // String -> JSONObject화

                    var _id = 0
                    var title: String? = null
                    var content: String? = null
                    var date: String? = null

                    // JSON Key 값대로 꺼냄
                    if (!obj.isNull("_id")) {
                        _id = obj.getInt("_id") // SQL _id 값
                    }
                    if (!obj.isNull("title")) {
                        title = obj.getString("title") // 제목
                    }
                    if (!obj.isNull("content")) {
                        content = obj.getString("content") // 파일 이름
                    }
                    if (!obj.isNull("date")) {
                        date = obj.getString("date") // 파일 이름
                    }

                    Logger.d(title)

                    val memoDataInfo = MemoDataInfo(_id, title, content, date)
                    view!!.getData(memoDataInfo)
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        } else {
            Logger.t("WriteFragment").d("memoArr Size 0")
        }
    }
}