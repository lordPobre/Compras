package com.example.compras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val viewModel: ItemViewModel) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var items = emptyList<Item>()// Lista de elementos inicialmente vacía

    // ViewHolder que contiene las vistas de cada elemento de la lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
    // Método llamado cuando RecyclerView necesita un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(itemView)
    }
    // Método llamado para actualizar el ViewHolder con los datos del elemento en la posición especificada
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.textView.text = currentItem.nombre
        holder.checkBox.isChecked = currentItem.comprado
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.update(Item(currentItem.id, currentItem.nombre, isChecked))
        }
    }
    // Método que devuelve el número total de elementos en la lista
    override fun getItemCount() = items.size
    // Método utilizado para actualizar la lista de elementos y notificar al RecyclerView que los datos han cambiado
    internal fun setItems(items: List<Any>) {
        this.items = items as List<Item>
        notifyDataSetChanged()
    }
}
