package paba.b.latihansharedprefereces

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

class adapterRecView(private val listtask: ArrayList<task>): RecyclerView
.Adapter<adapterRecView.ListViewHolder>() {
    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        //        var nama : String,
//        var vartanggal : Date,
//        var kategori : String,
//        var deskripsi : String,
//        var status : String,

        var _tvNamaTask = itemView.findViewById<TextView>(R.id.tvNamaTask)
        var _tvTanggalTask = itemView.findViewById<TextView>(R.id.tvTanggalTask)
        var _tvKategoriTask = itemView.findViewById<TextView>(R.id.tvKategoriTask)
        var _tvDeskripsiTask = itemView.findViewById<TextView>(R.id.tvDeskripsiTask)
        var _btnHapus = itemView.findViewById<Button>(R.id.btnHapus)
        var _btnUbah = itemView.findViewById<Button>(R.id.btnUbah)
        var _btnState = itemView.findViewById<Button>(R.id.btnState)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): adapterRecView.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_recycler, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listtask.size
    }
    private lateinit var onItemClickCallback: OnItemClickCallback
    interface OnItemClickCallback {
        fun onItemClicked(data:task)
        fun delData(pos:Int)
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onBindViewHolder(holder: adapterRecView.ListViewHolder, position: Int) {
        var task: task = listtask[position]
        holder._tvNamaTask.setText(task.nama)
        holder._tvDeskripsiTask.setText(task.deskripsi)
        holder._tvTanggalTask.setText(task.tanggal.toString())
        holder._tvKategoriTask.setText(task.kategori)
        holder._btnHapus.setOnClickListener {
            onItemClickCallback.delData(position)
        }
    }
}