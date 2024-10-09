package com.example.aplicacion2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilUsuarioScreen()
        }
    }
}

@Composable
fun PerfilUsuarioScreen() {
    val userName = remember { androidx.compose.runtime.mutableStateOf("") }
    val password = remember { androidx.compose.runtime.mutableStateOf("") }
    val newPassword = remember { androidx.compose.runtime.mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la pantalla
        Text(text = "Perfil de Usuario", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // Imagen de perfil (puedes usar una imagen local o un recurso en línea)
        Image(painter = painterResource(id = R.drawable.images), contentDescription = "Foto de Perfil", modifier = Modifier.size(100.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para nombre completo
        Text(text = "Nombre Completo")
        BasicTextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle Next action */ }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para cambiar la contraseña
        Text(text = "Cambiar Contraseña")
        BasicTextField(
            value = password.value,
            onValueChange = { password.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle Next action */ }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para nueva contraseña
        Text(text = "Nueva Contraseña")
        BasicTextField(
            value = newPassword.value,
            onValueChange = { newPassword.value = it },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar cambios
        Button(onClick = { /* Implementar acción para guardar cambios */ }) {
            Text(text = "Guardar Cambios")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPerfilUsuarioScreen() {
    PerfilUsuarioScreen()
}
