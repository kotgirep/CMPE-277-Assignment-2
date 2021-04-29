package sjsu.cmpe277.Assignment2

import android.content.Context
import android.net.image_uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_parameter1 = "parameter1"
//private const val ARG_parameter2 = "parameter2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DrawOneFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DrawOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DrawOneFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var parameter1: String? = null
//    private var parameter2: String? = null
//    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            parameter1 = it.getString(ARG_parameter1)
//            parameter2 = it.getString(ARG_parameter2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_draw_one, container, false)
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(image_uri: image_uri) {
//        listener?.onFragmentInteraction(image_uri)
//    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }


}
