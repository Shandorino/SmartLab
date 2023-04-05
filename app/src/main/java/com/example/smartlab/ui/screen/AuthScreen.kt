package com.example.smartlab.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.smartlab.R
import com.example.smartlab.screenModel.AuthScreenModel
import com.example.smartlab.ui.element.simple.MyButton
import com.example.smartlab.ui.element.simple.MyTextField
import com.example.smartlab.ui.theme.TextFieldBorder

class AuthScreen: Screen {

    @Composable
    override fun Content() {

        val screenModel = getScreenModel<AuthScreenModel>()

        val navigator = LocalNavigator.currentOrThrow

        val isSuc by screenModel.isSuc.collectAsState()

        val text: String? by screenModel.text_.collectAsState()

        var email by remember {
            mutableStateOf("")
        }

        Column(
            Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            
            Column(
                Modifier
                    .padding(horizontal = 20.dp, vertical = 75.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.hand), contentDescription = "", Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Добро пожаловать!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(25.dp))
                
                Text(text = "Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp)

                Spacer(modifier = Modifier.height(60.dp))

                Text(text = "Вход по E-mail", color = Color(0xff7E7E9A), fontSize = 14.sp)

                Spacer(modifier = Modifier.height(5.dp))
                
                MyTextField(value = email, onValueChange = {email = it}, placeholder = "example@mail.ru")

                Spacer(modifier = Modifier.height(30.dp))
                
                MyButton(
                    text = "Далее",
                    onClick = { screenModel.getCode(email) },
                    isActive = email.isNotEmpty()
                )

            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 75.dp)
            ) {
                Text(text = "Или войдите с помощью", color = Color(0xFF939396), fontSize = 15.sp)

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, color = TextFieldBorder, RoundedCornerShape(10.dp))
                ) {
                    Text(text = "Войти с Яндекс", fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 15.dp))
                }

            }
        }


        if (isSuc) navigator.push(EnterCodeScreen(email = email))


    }
}