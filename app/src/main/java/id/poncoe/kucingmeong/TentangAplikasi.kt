package id.poncoe.kucingmeong

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class TentangAplikasi : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tentang_aplikasi)
        title = "Tentang Aplikasi"

        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId === android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }

}