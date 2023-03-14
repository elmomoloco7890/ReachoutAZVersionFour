package prime.projects.reachoutazversionfour.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import prime.projects.reachoutazversionfour.R
import prime.projects.reachoutazversionfour.call.HotlineViewModel
import prime.projects.reachoutazversionfour.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding ?= null

    private val sharedViewModel: HotlineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding=homeBinding
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            homeFragment = this@HomeFragment
        }
    }

    fun goToMakeCall(){
        alertBox()
    }

    private fun alertBox(){
        val positiveButtonClick = { _: DialogInterface, _: Int ->
            sharedViewModel.shortToasts(requireActivity(), "You are cleared for take off.")
            //find nav controller here.
            findNavController().navigate(R.id.action_homeFragment_to_callFragment)
        }
        val negativeButtonClick = { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }

        val builder = AlertDialog.Builder(ContextThemeWrapper(requireActivity(), R.style.AlertDialogCustom))

        with(builder){
            setTitle("Warning")
            setMessage("Are you sure?")
            setPositiveButton("Ok", DialogInterface.OnClickListener(positiveButtonClick))
            setNegativeButton("Cancel", DialogInterface.OnClickListener(negativeButtonClick))
            show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding =  null
    }

}