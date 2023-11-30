package com.example.tourvista

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AgentSignupPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TravelAgentSignupDisplay()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelAgentSignupDisplay() {
    val context = LocalContext.current

    var companyname by remember { mutableStateOf("") }
    var cnic by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.agentt),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shadow(
                        8.dp, RoundedCornerShape(8.dp)
                    )
            )
            Text(
                text = "Create an Account",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color.White
            )
            OutlinedTextField(
                modifier = Modifier
                    .size(width = 270.dp, height = 60.dp),
                value = companyname,
                onValueChange = { companyname = it },
                label = { Text("Company Name", color = Color.White) },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .size(width = 270.dp, height = 60.dp),
                value = cnic,
                onValueChange = { cnic = it },
                label = { Text("CNIC", color = Color.White) },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .size(width = 270.dp, height = 60.dp),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White) },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .size(width = 270.dp, height = 60.dp),
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number", color = Color.White) },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )
            OutlinedTextField(
                modifier = Modifier
                    .size(width = 270.dp, height = 60.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                )
            )
            Button(
                onClick = {
                    val dbHelper = DatabaseHelper(context)
                    dbHelper.registerAgent(companyname, cnic, email, phoneNumber, password)
                    Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT).show()
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
                    text = "SignUp",
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
        }
    }
}