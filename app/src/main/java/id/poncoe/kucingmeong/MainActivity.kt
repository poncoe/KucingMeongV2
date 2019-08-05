package id.poncoe.kucingmeong

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKuchink: RecyclerView
    private var list: ArrayList<Kucing> = arrayListOf()
    private var title: String = "Kucing Meonk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvKuchink = findViewById(R.id.rv_kuchink)

        /** Baris di bawah menjelaskan bahwa bila fixed size bernilai true, maka RecyclerView dapat melakukan optimasi ukuran lebar dan tinggi secara otomatis.
         * Nilai lebar dan tinggi RecyclerView menjadi konstan. Terlebih jika kita memiliki koleksi data yang dinamis untuk proses penambahan, perpindahan,
         * dan pengurangan item dari koleksi data. */

        rvKuchink.setHasFixedSize(true)

        //list.addAll(DataKucing.listData())
        list.addAll(DataKucing.listData)
        showRecyclerCardView()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    /** Pada sisi fleksibilitas setLayoutManager(), RecyclerView memiliki beragam bentuk yang disesuaikan dengan design yang diinginkan.
     * Kita hanya perlu menentukan nilai pada metode setLayoutManager() saja untuk menentukan bagaimana RecyclerView ditampilkan. */

    private fun showRecyclerCardView() {
        rvKuchink.layoutManager = LinearLayoutManager(this)
        val cardviewKucingAdapter = KucingAdapter(list,this)
        rvKuchink.adapter = cardviewKucingAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.abotme -> {
                val i = Intent(this@MainActivity, TentangAplikasi::class.java)
                startActivity(i)
                title = "Tentang Aplikasi"
            }
        }
    }

    private fun exit() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Apakah yakin ingin keluar?").setCancelable(false)
            // tidak bisa tekan tombol back
            // jika pilih yess
            .setPositiveButton("Ya",
                { dialog, id -> finish() })
            // jika pilih no
            .setNegativeButton("Tidak",
                { dialog, id -> dialog.cancel() }).show()

    }

    override fun onBackPressed() {
        exit()
    }

}