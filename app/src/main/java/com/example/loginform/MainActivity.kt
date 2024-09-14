package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

val primaryColor = Color(0xFF4B10B4)
val unfocusedColor = Color(0x7E706C83)

@Composable
fun customTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = Color.Black,
    unfocusedTextColor = Color.Black,
    focusedContainerColor = Color.Transparent,
    unfocusedContainerColor = Color.Transparent,
    disabledContainerColor = Color.Transparent,
    errorContainerColor = Color.Transparent,
    focusedBorderColor = primaryColor,
    unfocusedBorderColor = unfocusedColor,
    focusedLabelColor = primaryColor,
    unfocusedLabelColor = unfocusedColor,

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var eemaili: String by remember { mutableStateOf("") }
    var passuu: String by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Login",
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF4B10B4),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        OutlinedTextField(
            value = eemaili,
            onValueChange = { eemaili = it },
            label = { Text("Username",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
            ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            trailingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = customTextFieldColors()
        )
        OutlinedTextField(
            value = passuu,
            onValueChange = { passuu = it },
            label = { Text("Password",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password") },
            modifier = Modifier.fillMaxWidth(),
            colors = customTextFieldColors()
        )
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            shape = MaterialTheme.shapes.extraSmall
        ) {
            Text(text = "Submit",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
       LoginForm()
    }
}