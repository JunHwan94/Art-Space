package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

val artworkIdxs = listOf(0, 1, 2)
@Composable
fun ArtSpaceLayout() {
    Column(
        modifier = Modifier.statusBarsPadding()
            .padding(20.dp)
            .safeDrawingPadding(),
        verticalArrangement = Arrangement.Center
    ) {
        var currentArtwork by remember { mutableIntStateOf(0) }
        Artwork(currentArtwork)
        Spacer(modifier = Modifier.size(15.dp))
        ArtDescription(currentArtwork)
        Spacer(modifier = Modifier.size(15.dp))
        BottomButtons(
            onClickPrev = {
                if(currentArtwork == 0) {
                    currentArtwork = 2
                } else {
                    currentArtwork -= 1
                }
            },
            onClickNext = {
                if(currentArtwork == 2) {
                    currentArtwork = 0
                } else {
                    currentArtwork += 1
                }
            }
        )
    }
}
@Composable
fun Artwork(currentArtwork: Int) {
    val drawable = when(currentArtwork) {
        artworkIdxs[0] -> R.drawable.art_0
        artworkIdxs[1] -> R.drawable.art_1
        artworkIdxs[2] -> R.drawable.art_2
        else -> R.drawable.art_0
    }
    Surface(modifier = Modifier.wrapContentSize(), shadowElevation = 5.dp) {
        Image(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp),
            painter = painterResource(drawable),
            contentDescription = "sunflower"
        )
    }
}

@Composable
fun ArtDescription(currentArtwork: Int) {
    val titleRes = when(currentArtwork) {
        artworkIdxs[0] -> R.string.title_art_0
        artworkIdxs[1] -> R.string.title_art_1
        artworkIdxs[2] -> R.string.title_art_2
        else -> R.string.title_art_0
    }
    val artistRes = when(currentArtwork) {
        artworkIdxs[0] -> R.string.artist_art_0
        artworkIdxs[1] -> R.string.artist_art_1
        artworkIdxs[2] -> R.string.artist_art_2
        else -> R.string.artist_art_0
    }
    Column(
        modifier = Modifier.fillMaxWidth().background(color = Color.LightGray)
            .padding(vertical = 10.dp, horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(artistRes),
            style = MaterialTheme.typography.titleSmall,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomButtons(onClickPrev: () -> Unit, onClickNext: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp),
    ) {
        Button(
            modifier = Modifier.fillMaxWidth().weight(1.0f),
            onClick = onClickPrev
        ) {
            Text(stringResource(id = R.string.previous))
        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth().weight(1.0f),
            onClick = onClickNext
        ) {
            Text(stringResource(id = R.string.next))
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