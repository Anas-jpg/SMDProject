package com.example.smdproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.smdproject.ui.theme.SMDProjectTheme

class HistoryDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMDProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {


                }
            }
        }
    }
}

data class Card(
    val image: String,
    val dateOfVisit: String,
    val locationName: String
)


@Composable
fun VisitedPlacesScreen(
    visitedPlaces: List<Card>
) {


    val backgroundImage = R.drawable.birds


    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(painter = painterResource(id = R.drawable.backgroundplace), contentDescription = "null",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.girl),
            contentDescription = "Your Description",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = "Visited Places",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 16.dp,vertical = 16.dp),
            color = Color.White
        )
        visitedPlaces.forEach { place ->
            VisitedPlaceCard(place)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitedPlaceCard(place: Card) {

    val colors = TextFieldDefaults.textFieldColors(
        containerColor = Color(0, 0, 0, 100) // Alpha set to 128 for 50% transparency
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color(0,0,0,100), //Card background color
            contentColor = Color.White  //Card content color,e.g.text
        )

    )
    {
        Row(
            modifier = Modifier.padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        )




        {
            Image(
                painter = rememberImagePainter(data = place.image),
                contentDescription = "Image of ${place.locationName}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = place.locationName,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = place.dateOfVisit,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}