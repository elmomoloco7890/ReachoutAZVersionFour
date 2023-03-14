package prime.projects.reachoutazversionfour.call

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import prime.projects.reachoutazversionfour.databinding.HotlineItemBinding

class HotlineAdapter(
    private val viewModel: HotlineViewModel,
    private val hotlineItemClickListener: HotlineItemClickListener
): RecyclerView.Adapter<HotlineAdapter.HotlineViewHolder>() {

    //define the binding for the item layout
    private lateinit var binding: HotlineItemBinding

    //the class call hotlineViewHolder
    class HotlineViewHolder(var hotlineView: HotlineItemBinding): RecyclerView.ViewHolder(hotlineView.root){
        //will be adding this in a bit.
         fun bind(currentLine: Hotlines, listener: HotlineItemClickListener){
            hotlineView.hotlines = currentLine
            hotlineView.hotlineItemClick = listener
            hotlineView.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotlineViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val hotlineViewBinding = HotlineItemBinding.inflate(inflater, parent, false)
        binding = hotlineViewBinding
        return HotlineViewHolder(hotlineViewBinding)
    }

    override fun getItemCount(): Int = viewModel.getHotlineCount()

    override fun onBindViewHolder(holder: HotlineViewHolder, position: Int) =
        holder.bind(viewModel.getHotlineItems(position), hotlineItemClickListener)
}