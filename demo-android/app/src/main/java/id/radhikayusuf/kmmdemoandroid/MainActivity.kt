package id.radhikayusuf.kmmdemoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.radhikayusuf.lib.auth.data.repository.LoginRepositoryImpl
import com.radhikayusuf.lib.auth.domain.entities.UserEntity
import com.radhikayusuf.lib.auth.domain.presenters.LoginPresenter
import com.radhikayusuf.lib.auth.domain.usecases.LoginUseCase
import com.radhikayusuf.lib.auth.utils.UserPreferences
import id.radhikayusuf.kmmdemoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LoginPresenter {

    private val pref = UserPreferences(this)
    private val loginRepository = LoginRepositoryImpl(preferences = pref)
    private val loginUseCase = LoginUseCase(loginRepository, this)

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    fun buttonLoginClickEvent(view: View) {
        loginUseCase.doLoginByKey(viewBinding.text.text.toString())
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Success Login ${pref.getString(UserEntity.KEY_USER_NAME)}", Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}