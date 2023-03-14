package prime.projects.reachoutazversionfour.call

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import prime.projects.reachoutazversionfour.R
import prime.projects.reachoutazversionfour.databinding.FragmentCallBinding


class CallFragment : Fragment(), HotlineItemClickListener {

    private var binding: FragmentCallBinding ?= null

    private val sharedViewModel: HotlineViewModel by activityViewModels()

    private lateinit var adapter: HotlineAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val callBinding = FragmentCallBinding.inflate(inflater, container, false)
        binding = callBinding
        return callBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HotlineAdapter(sharedViewModel, this)
        binding?.apply {
            callFragment = this@CallFragment
            hotlineAdapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onHotlineItemClick(hotlines: Hotlines) {
        for (calling in 1..3){
            if (calling == 1){
                makeTheCall(hotlines)
                break
            }
        }
    }

    private fun makeTheCall(hotlines: Hotlines){
        //create the alertbox
        makeAlertBox(hotlines)

    }

    private fun makeAlertBox(hotlines: Hotlines){

         val positiveButtonClick = { _: DialogInterface, _: Int ->
            //sharedViewModel.shortToasts(requireActivity(), "You are cleared for take off.")
            //find nav controller here.
             val dialIntent = Intent(Intent.ACTION_DIAL)
             dialIntent.data = Uri.parse("tel: ${hotlines.hotlineNumbers}")
             activity?.startActivityFromFragment(this, dialIntent, 101)
            findNavController().navigate(R.id.action_callFragment_to_homeFragment)
        }
        val negativeButtonClick = { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }

        val builder = AlertDialog.Builder(ContextThemeWrapper(requireActivity(), R.style.AlertDialogCustom))

        with(builder){
            setTitle("Warning")
            setMessage("Are you sure? You have called ${hotlines.hotlineNumbers}")
            setPositiveButton("Ok", DialogInterface.OnClickListener(positiveButtonClick))
            setNegativeButton("Cancel", DialogInterface.OnClickListener(negativeButtonClick))
            show()
        }

        /*sharedViewModel.longToasts(
            requireActivity(),
            "You have chosen ${hotlines.hotlineLabel}, \n ${hotlines.hotlineNumbers} ")*/
    }


}