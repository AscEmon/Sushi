import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sushi.features.home.ProductItem
import com.example.sushi.features.home.ProductViewModel
import com.example.sushi.navigation.routes.Routes
import com.example.sushi.ui.common.BaseScreen

@Composable
fun ProductListScreen(
    navController: NavController, viewModel: ProductViewModel = viewModel()
) {
    val products = viewModel.products.value

    BaseScreen(
        title = "Products", navController = navController, content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)

            ) {
                items(products) { product ->
                    ProductItem(product, onClick = {
                        navController.navigate("${Routes.PRODUCT_DETAIL}/${product.id}")
                    })
                }
            }
        }

    )

}
