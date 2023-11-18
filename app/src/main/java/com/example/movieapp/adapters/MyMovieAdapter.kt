import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.movieapp.databinding.ItemRvBinding
import com.example.movieapp.models.MyMovie
import com.example.movieapp.utils.MySharedPreference

class MyMovieAdapter(var rvAction: RvAction, var list: ArrayList<MyMovie>) :
    RecyclerView.Adapter<MyMovieAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : ViewHolder(itemRvBinding.root) {

        fun onBind(myMovie: MyMovie, position: Int) {
            itemRvBinding.tvName.text = myMovie.name
            itemRvBinding.tvAuthors.text = myMovie.authors
            itemRvBinding.tvDate.text = myMovie.date

            itemRvBinding.root.setOnClickListener {
                rvAction.myItemtemClick(myMovie, position)
            }

            itemRvBinding.btnEdt.setOnClickListener {
                rvAction.edit(position)

            }
            itemRvBinding.btnDelete.setOnClickListener {
                list.remove(myMovie)
                this@MyMovieAdapter.notifyItemRemoved(position)
                MySharedPreference.MySharedPreference.list=list
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface RvAction {
        fun myItemtemClick(myMovie: MyMovie, position: Int)
        fun edit(position: Int)
    }


}
