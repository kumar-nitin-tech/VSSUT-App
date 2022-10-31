package com.example.memeshare

import android.app.DownloadManager.Request
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.memeshare.ui.theme.MemeShareTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    MemeShareTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ScreenContent()
        }
    }
}

@Composable
fun ScreenContent() {
    val context:Context = LocalContext.current
    val imageUrl:MutableState<String> = remember {
        mutableStateOf("")
    }
    loadImageUrl(context,imageUrl)
        Box(
            contentAlignment = Alignment.Center
            ) {
            MemeImage(imageUrl.value)
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MemeButton(context,imageUrl)
        }
}

@Composable
fun MemeButton(context: Context,imageUrl: MutableState<String>) {

    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ){
       Button(onClick = {
           val url = imageUrl.value
           val intent = Intent()
           intent.action = Intent.ACTION_SEND
           intent.putExtra(Intent.EXTRA_TEXT,"Hey Check Out this Meme $url")
           intent.type = "text/plain"
           startActivity(context,Intent.createChooser(intent,"Share this meme"),null)
       }) {
           Text(text = "Share")
       }

        Button(onClick = {
            loadImageUrl(context,imageUrl)

        }) {
            Text(text = "Next")
        }
    }
}

@Composable
fun MemeImage(imageUrl:String) {
    AsyncImage(model = imageUrl, contentDescription ="" )
}

fun loadImageUrl(context: Context,imageUrl:MutableState<String>){
    val queue = Volley.newRequestQueue(context)
    val url = "https://meme-api.herokuapp.com/gimme"

    val jsonObjectRequest = JsonObjectRequest(com.android.volley.Request.Method.GET,url,null,{
        response-> val img = response.getString("url")
        imageUrl.value = img
    },{
        error-> Toast.makeText(context,"fail",Toast.LENGTH_SHORT).show()
    })

    queue.add(jsonObjectRequest)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemeShareTheme {
        ScreenContent()
    }
}