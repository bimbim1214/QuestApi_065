import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remotedatabase.MahasiswaAplications
import com.example.remotedatabase.ui.viewmodel.HomeViewModel
import com.example.remotedatabase.ui.viewmodel.InsertViewModel
import com.example.remotedatabase.ui.viewmodel.UpdateViewModel
  // Make sure to import this ViewModel if it's defined

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { InsertViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { DetailViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer {
            UpdateViewModel(
                createSavedStateHandle(),
                aplikasiMahasiswa().container.mahasiswaRepository
            )
        }
    }
}

fun CreationExtras.aplikasiMahasiswa(): MahasiswaAplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaAplications)
