package br.com.brunocardoso.studying.androidtestinstrumental.repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunocardoso.studying.androidtestinstrumental.MyApplication
import br.com.brunocardoso.studying.androidtestinstrumental.R
import kotlinx.android.synthetic.main.activity_repository.*

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        setupViewModel()
    }

    private fun setupViewModel() {
        val viewModel = ViewModelProviders.of(this,
            RepositoryViewModel.RepositoryViewModelFactory(getBaseUrl())
        ).get(RepositoryViewModel::class.java)


        viewModel.items.observe(this, Observer {
            recycler_view.layoutManager = LinearLayoutManager(this)

            if (it?.isEmpty() == false) {
                recycler_view.adapter = RepositoryAdapter(it)
            } else {
                view_flipper.displayedChild = 1
            }
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, "#erro", Toast.LENGTH_SHORT).show()
        })

        viewModel.fetchRepositories()
    }

    private fun getBaseUrl() = (application as MyApplication).getUrl()
}