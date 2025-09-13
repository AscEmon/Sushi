import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sushi.features.home.ProductItem
import com.example.sushi.features.home.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products = viewModel.products.value

    LazyColumn(
        contentPadding = PaddingValues(
            top = 60.dp,
            start = 16.dp,
            end = 16.dp,
            bottom = 16.dp
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}
