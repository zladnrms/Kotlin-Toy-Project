package defytech.zladnrms.kotlin_toy_project.model

import android.content.Context
import java.util.ArrayList

/**
 * Created by kim on 2017-09-16.
 */
interface LocalDataRepositoryModel {
    /* 데이터 추가 */
    fun insert(context: Context, title: String, content: String)

    /* 데이터 가져옴 */
    fun getData(context: Context): ArrayList<String>

    /* 데이터 삭제 */
    fun delData(context : Context, id : Int)
}