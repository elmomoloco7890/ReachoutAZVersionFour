package prime.projects.reachoutazversionfour.call

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class HotlineViewModel: ViewModel() {

    var hotlineRepo = HotlineRepo()

    var hotlineRepoArray = hotlineRepo.getHotlineData()

    fun getHotlineItems(position: Int): Hotlines{
        return hotlineRepoArray[position]
    }

    fun getHotlineCount(): Int{
        return hotlineRepoArray.size
    }

    fun shortToasts(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun longToasts(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}