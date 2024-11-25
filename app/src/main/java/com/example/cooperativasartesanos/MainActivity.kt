package com.example.cooperativasartesanos
import GridAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Rect
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3 columnas
        recyclerView.addItemDecoration(SpacingItemDecoration(16)) // 16dp de espacio


        // Lista de elementos de la cuadrícula
        val items = listOf(
            GridItem(R.drawable.image1, "Juan Pérez", "Oaxaca"),
            GridItem(R.drawable.image2, "María López", "Chiapas"),
            GridItem(R.drawable.image3, "Carlos García", "Guerrero"),
        )


        // Adaptador
        val adapter = GridAdapter(items) { item ->
            // Acción al hacer clic
            Toast.makeText(this, "Clic en: ${item.title}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }
}


class SpacingItemDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(spacing, spacing, spacing, spacing)
    }
}

