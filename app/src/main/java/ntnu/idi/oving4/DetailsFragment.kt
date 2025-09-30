package ntnu.idi.oving4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment: Fragment() {

    // Creates the view for the fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_item, container, false)
    }


    // Updates the details view with the selected movie's information
    fun showDetails(index: Int) {
        val movie = Movie.entries[index]
        view?.findViewById<ImageView>(R.id.movieImage)?.setImageResource(movie.imageRes)
        view?.findViewById<TextView>(R.id.movieTitle)?.text = movie.title
        view?.findViewById<TextView>(R.id.movieDesc)?.text = movie.description
    }
}