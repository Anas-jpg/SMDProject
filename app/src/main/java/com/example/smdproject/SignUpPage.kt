package com.example.smdproject

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TextButton
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
import com.example.tourvista.AgentSignupPage
import com.example.tourvista.DatabaseHelper
import com.example.tourvista.LoginPage

class SignUpPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SignupPageDisplay()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupPageDisplay() {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
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
                painter = painterResource(id = R.drawable.hto),
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
                value = username,
                onValueChange = { username = it },
                label = {
                    Text(
                        "Username",
                        color = Color.White,
                    )
                },
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(23.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White,
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
                    dbHelper.registerUser(username, email, phoneNumber, password)
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
                    text = "SignIn",
                    color = Color.White,
                    fontSize = 18.sp,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("If you are Travel Agent then ", fontSize = 15.sp, color = Color.White)
                Spacer(modifier = Modifier.width(4.dp)) // Add some space between the texts
                TextButton(
                    onClick = {
                        val intent = Intent(context, AgentSignupPage::class.java)
                        context.startActivity(intent)
                    }
                ) {
                    Text(
                        "Click Here!!",
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}