package defytech.zladnrms.kotlin_toy_project.view.`interface`

import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import java.util.ArrayList

/**
 * Created by kim on 2017-09-14.
 */
interface HomeView : BaseView {

    /* 데이터 가져오기*/
    fun getLocalData()

    /* 데이터 가져옴 (JSON 형태) */
    fun getDataArr(memoArr: ArrayList<String>)

    /* 데이터 하나 뽑아옴 */
    fun getData(memoDataInfo: MemoDataInfo)

    /* 목록 갱신*/
    fun refresh()

    /* 목록 비우기 */
    fun clear()
}