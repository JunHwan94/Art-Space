package com.example.artspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    Column(
        modifier = Modifier.statusBarsPadding()
            .padding(20.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .border(width = 1.dp, color = Color.Red)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            painter = painterResource(R.drawable.img),
            contentDescription = "sunflower"
        )
        Spacer(modifier = Modifier.size(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
                .border(width = 1.dp, color = Color.Red)
                .padding(vertical = 10.dp, horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Artwork Title", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "Artwork Artist (Year)", style = MaterialTheme.typography.titleSmall, textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
                .border(width = 1.dp, color = Color.Red)
                .padding(vertical = 5.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(modifier = Modifier.wrapContentSize(), onClick = { Log.d("Button", "clicked") }) { }
            Button(modifier = Modifier.wrapContentSize(), onClick = { Log.d("Button", "clicked") }) { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}