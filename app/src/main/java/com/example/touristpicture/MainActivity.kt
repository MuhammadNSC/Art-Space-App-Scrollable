package com.example.touristpicture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.touristpicture.ui.theme.TouristPictureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           TouristPictureTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageSlider()
                }
            }
        }
    }
}

@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )
    val descriptions = listOf(
        R.string.picture1,
        R.string.picture2,
        R.string.picture3,
        R.string.picture4,
        R.string.picture5,
        R.string.picture6,
        R.string.picture7,
        R.string.picture8,
        R.string.picture9,
        R.string.picture10
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(images.size) { index ->
            ImageWithText(
                imageResId = images[index],
                descriptionResId = descriptions[index]
            )
        }
    }
}

@Composable
fun ImageWithText(imageResId: Int, descriptionResId: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = descriptionResId),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   TouristPictureTheme() {
        ImageSlider()
    }
}
