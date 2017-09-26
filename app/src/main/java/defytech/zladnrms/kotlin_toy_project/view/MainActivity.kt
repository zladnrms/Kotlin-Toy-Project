package defytech.zladnrms.kotlin_toy_project.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import defytech.zladnrms.kotlin_toy_project.R
import defytech.zladnrms.kotlin_toy_project.adapter.view.MemoListAdapterKt
import defytech.zladnrms.kotlin_toy_project.model.DataInfo.MemoDataInfo
import defytech.zladnrms.kotlin_toy_project.presenter.MainPresenter
import defytech.zladnrms.kotlin_toy_project.view.`interface`.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var presenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            val homeFragment : Fragment = HomeFragment()
            val fm : FragmentManager = supportFragmentManager
            val ft : FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.layoutMain, homeFragment, "main")
            ft.commit()
        }
    }

    override fun switchFragment(fragment: Fragment, tag: String) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.layoutMain, fragment, tag)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val fm = supportFragmentManager
        fm.popBackStackImmediate()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
