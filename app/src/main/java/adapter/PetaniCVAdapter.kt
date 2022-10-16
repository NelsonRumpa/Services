package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.service.R
import model.Petani

class PetaniCVAdapter (val petani: List<Petani.Petani>): RecyclerView.Adapter<PetaniCVAdapter.PetaniHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PetaniCVAdapter.PetaniHolder {
        return PetaniHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cv_item_petani, parent, false))
    }

    override fun onBindViewHolder(holder: PetaniCVAdapter.PetaniHolder, position: Int) {
        holder.bindPetani(petani[position])
    }

    override fun getItemCount(): Int {
        return petani.size
    }

    class PetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtUser: TextView
        lateinit var txtNama: TextView
        lateinit var txtJumlahLahan: TextView
        lateinit var txtIdentifikasi: TextView
        lateinit var txtTambahLahan: TextView

        fun bindPetani(petani: Petani.Petani) {
            itemView.apply {
                txtUser = findViewById(R.id.txtUser)
                txtNama = findViewById(R.id.txtNama)
                txtJumlahLahan = findViewById(R.id.txtJumlahLahan)
                txtIdentifikasi = findViewById(R.id.txtIdentifikasi)
                txtTambahLahan = findViewById(R.id.txtTambahLahan)
                txtUser.text = petani.user
                txtNama.text = petani.nama
                txtJumlahLahan.text = petani.jumlahLahan
                txtIdentifikasi.text = petani.identifikasi
                txtTambahLahan.text = petani.tambahLahan
            }
        }
    }
}