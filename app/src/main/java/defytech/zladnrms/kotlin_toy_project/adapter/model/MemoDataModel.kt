package defytech.zladnrms.kotlin_toy_project.adapter.model

import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo

/**
 * Created by kim on 2017-09-20.
 */
interface MemoDataModel {
    /* 데이터 추가 */
    fun add(memoDataInfo: MemoDataInfo)

    /* 데이터 제거 */
    fun remove(position: Int)

    /* 데이터 초기화*/
    fun clear()
}