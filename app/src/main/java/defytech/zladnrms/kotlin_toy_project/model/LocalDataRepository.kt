package defytech.zladnrms.kotlin_toy_project.model

import android.content.Context
import com.orhanobut.logger.Logger
import defytech.zladnrms.kotlin_toy_project.model.SQLite.MemoSQLHelper
import java.util.ArrayList

/**
 * Created by kim on 2017-09-20.
 */
class LocalDataRepository : LocalDataRepositoryModel {

    companion object {
        fun getInstance(): LocalDataRepository {
            return LocalDataRepository()
        }
    }

    override fun insert(context: Context, title: String, content: String) {
        val memoSQL = MemoSQLHelper(context.getApplicationContext(), "MemoData.db", null, 1)
        memoSQL.insert(title, content)
    }

    override fun getData(context: Context): ArrayList<String> {
        val memoSQL = MemoSQLHelper(context.getApplicationContext(), "MemoData.db", null, 1)
        val memoArr = memoSQL.data

        Logger.t("LocalDataRepository-getData").d(memoArr)

        return memoArr
    }

    override fun delData(context: Context, id : Int) {
        val memoSQL = MemoSQLHelper(context.getApplicationContext(), "MemoData.db", null, 1)
        memoSQL.delete(id)
    }
}
