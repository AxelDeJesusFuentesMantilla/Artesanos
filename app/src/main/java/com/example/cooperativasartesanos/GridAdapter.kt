import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cooperativasartesanos.GridItem
import com.example.cooperativasartesanos.R

class GridAdapter(
    private val items: List<GridItem>,        // Lista de elementos
    private val onClick: (GridItem) -> Unit  // Acción al hacer clic
) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    // ViewHolder: Maneja las vistas individuales
    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewRegion: TextView = view.findViewById(R.id.textViewRegion) // Agregar esta línea
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val item = items[position]

        // Usar Glide para cargar la imagen circular
        Glide.with(holder.itemView.context)
            .load(item.imageResId)
            .circleCrop()
            .into(holder.imageView)

        // Asignar valores al nombre y región
        holder.textViewName.text = item.title
        holder.textViewRegion.text = item.region

        // Acción de clic
        holder.itemView.setOnClickListener { onClick(item) }
    }




    override fun getItemCount() = items.size
}
