package ir.ebcom.lazycolumnsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ebcom.lazycolumnsample.ui.theme.LazyColumnSampleTheme
import ir.ebcom.lazycolumnsample.ui.theme.pastelLemon
import ir.ebcom.lazycolumnsample.ui.theme.pastelPink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnSampleTheme {
                val windowInfo = fetchWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        items(10){
                            Text(
                                text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(pastelLemon)
                                    .padding(16.dp)
                            )
                        }
                        items(10){
                            Text(
                                text = "Item $it",
                                fontSize = 25.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(pastelPink)
                                    .padding(16.dp)
                            )
                        }
                    }
                }else {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        LazyColumn(
                            modifier = Modifier.weight(1f)
                        ){
                            items(10){
                                Text(
                                    text = "Item $it",
                                    fontSize = 50.sp,
                                    modifier = Modifier.fillMaxWidth()
                                        .background(pastelLemon)
                                        .padding(16.dp)
                                )
                            }
                        }
                        LazyColumn(
                            modifier = Modifier.weight(1f)
                        ){
                            items(10){
                                Text(
                                    text = "Item $it",
                                    fontSize = 50.sp,
                                    modifier = Modifier.fillMaxWidth()
                                        .background(pastelPink)
                                        .padding(16.dp)
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumnSampleTheme {
        Greeting("Android")
    }
}