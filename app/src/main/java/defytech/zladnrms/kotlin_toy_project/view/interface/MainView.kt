package defytech.zladnrms.kotlin_toy_project.view.`interface`

import android.content.Context
import android.support.v4.app.Fragment
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import java.util.ArrayList

/**
 * Created by kim on 2017-09-14.
 */
interface MainView : BaseView {
    fun switchFragment(fragment: Fragment, tag: String)
}