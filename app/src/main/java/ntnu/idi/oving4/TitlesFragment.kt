package ntnu.idi.oving4

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class TitlesFragment: ListFragment() {

    interface OnTitleSelectedListener {
        fun onTitleSelected(index: Int)
    }

    private var listener: OnTitleSelectedListener? = null

    // Sets up the list adapter with movie titles
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            Movie.entries.map { it.title }
        )
    }

    // Handles list item clicks and notifies the listener
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        listener?.onTitleSelected(position)
    }

    // Connects the fragment to the activity
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnTitleSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnTitleSelectedListener")
        }
    }

    // Disconnects the fragment from the activity
    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}