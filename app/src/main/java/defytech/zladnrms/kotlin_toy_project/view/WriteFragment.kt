package defytech.zladnrms.kotlin_toy_project.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import defytech.zladnrms.kotlin_toy_project.R
import defytech.zladnrms.kotlin_toy_project.adapter.view.MemoListAdapterKt
import defytech.zladnrms.kotlin_toy_project.presenter.WritePresenter
import defytech.zladnrms.kotlin_toy_project.view.`interface`.WriteView
import kotlinx.android.synthetic.main.fragment_write.*

/**
 * Created by kim on 2017-09-20.
 */
class WriteFragment : Fragment(), WriteView {

    private var presenter : WritePresenter? = null

    companion object {
        fun newInstance(): WriteFragment {
            return WriteFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_write, container, false)

        presenter = WritePresenter()
        presenter?.attachView(this)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnReset.setOnClickListener{
            etTitle.setText("")
            etContent.setText("")
        }

        btnSubmit.setOnClickListener{
            etTitle?.text.toString().let {  }
            Logger.t("WriteFragment : btnSubmit").d("제목 : " + etTitle.text.toString() + ", 내용 : " + etContent.text.toString())
            presenter?.addData(activity, etTitle.text.toString(), etContent.text.toString())
            //(activity as MainActivity).switchFragment(HomeFragment(), "home")
            (activity as MainActivity).onBackPressed()
        }
    }
}