import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remotedatabase.model.Mahasiswa
import com.example.remotedatabase.repository.MahasiswaRepository
import com.example.remotedatabase.ui.viewmodel.InsertUiEvent
import kotlinx.coroutines.launch


data class DetailUiState(
    val detailUiEvent: InsertUiEvent = InsertUiEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
) {
    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != InsertUiEvent()
}

fun Mahasiswa.toDetailUiEvent(): InsertUiEvent {
    return InsertUiEvent(
        nim = nim,
        nama = nama,
        alamat = alamat,
        jenisKelamin = jenisKelamin,
        kelas = kelas,
        angkatan = angkatan
    )
}