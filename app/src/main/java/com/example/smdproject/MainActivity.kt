package com.example.smdproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smdproject.ui.theme.SMDProjectTheme
import com.example.tourvista.LoginPage
import com.example.tourvista.SignUpPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMDProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                )
                {
                   // SignUpScreen()

                    val visitedPlaces = listOf(
                        Card(image = "https://images.unsplash.com/photo-1550586678-f7225f03c44b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fG11cnJlZXxlbnwwfHwwfHx8MA%3D%3D", dateOfVisit = "24/11/2023", locationName = "Murree"),
                        Card(image = "https://images.unsplash.com/photo-1552098933-a5ceb0e5dd91?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGthc2htaXJ8ZW58MHx8MHx8fDA%3D", dateOfVisit = "12/09/2023", locationName = "Kashmir"),
                        Card(image = "https://againstthecompass.com/wp-content/uploads/2017/07/nanga-parbat-base-camp-e1541587927392.jpg", dateOfVisit = "17/05/2021", locationName = "Fairy Meadows"),
                        Card(image = "https://www.aljazeera.com/wp-content/uploads/2023/06/2023-01-27T103518Z_833375341_RC2SYY96BKU0_RTRMADP_3_SINGAPORE-TOURISM-1685936603.jpg?resize=1800%2C1800", dateOfVisit = "12/09/2013", locationName = "Singapore")

                    )

                    VisitedPlacesScreen(visitedPlaces)




                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
@Preview
fun GreetingPreview() {
    SMDProjectTheme {
        ExpandableCard("Lahore")
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {

    val backgroundImage = R.drawable.background


    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        Image(painter = painterResource(id = R.drawable.background), contentDescription = "null",
                contentScale = ContentScale.FillBounds,
                 modifier = Modifier.matchParentSize()
            )

    }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )


    {
        // Add the image on top
        Image(
            painter = painterResource(id = R.drawable.traveler1), // Replace with your image resource
            contentDescription = null, // Provide a content description
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium).padding(40.dp),
            contentScale = ContentScale.Crop
        )
        val colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0, 0, 0, 100) // Alpha set to 128 for 50% transparency
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Edit Profile",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier.padding(start = 100.dp, top = 16.dp)
        )


        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Name", color = Color.White) },
            leadingIcon = { Icon(Icons.Default.Place, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
               colors = colors
        )


        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Email", color = Color.White) },
            leadingIcon = { Icon(Icons.Default.MailOutline, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = colors

        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Phone number" , color = Color.White) },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = colors

        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password", color = Color.White) },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Share, contentDescription = null) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = colors


        )

        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Confirm password", color = Color.White) },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.MailOutline, contentDescription = null) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = colors

        )

        Spacer(modifier = Modifier.height(16.dp))
        // Add more text fields for other information if needed (e.g., gender)

        Text(text = "Gender",
            color = Color.White,

            )

        RadioButtonSample()

        Button(
            onClick = { /* Handle click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.padding(start = 110.dp,top = 16.dp)
        ) {
            Text(
                text = "Update Profile",
                color = Color.White
            )
        }




    }
}

@Composable
fun RadioButtonSample() {
    val radioOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .weight(1f)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodySmall.merge(),
                    modifier = Modifier.padding(top = 13.dp,start = 8.dp),
                    color = Color.White,
                )
            }
        }
    }
}


@Composable
fun ExpandableCard(title: String) {

    var expanded by remember { mutableStateOf (false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp).clickable(
                onClick = {expanded = !expanded}
            )

    ) {
        Column(
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp)
            )
            if (expanded) {
                Text(
                    text = "Content Sample for Display on Expansion of Card",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}



@Composable
fun MainPage() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0D47A1),
                        Color(0xFF42A5F5)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.girl),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )
            Text(
                text = "TourVista",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Unveil the Explorer in You",
                fontSize = 12.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(60.dp))
            Button(
                onClick = {
                    val intent = Intent(context, LoginPage::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFF1565C0))
                    .border(2.dp, Color.White, shape = RoundedCornerShape(26.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF0D47A1)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val intent = Intent(context, SignUpPage::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFF1565C0))
                    .border(2.dp, Color.White, shape = RoundedCornerShape(26.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF0D47A1)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "SignUp",
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
