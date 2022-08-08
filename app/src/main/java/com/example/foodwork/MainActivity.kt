package com.example.foodwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodwork.ui.theme.FoodworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodworkTheme {
                // A surface container using the 'background' color from the theme
                Foodwork()
            }
        }
    }
}

@Composable
fun Foodwork(){
    var currentPage by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
        when (currentPage){
            1 -> {
                Page1(
                    //textLabelResourceID = ,
                    drawableResourceID = R.drawable.logo,
                    contentDescriptionResourceId = R.string.logo_content_description,
                    onButtonClick = {currentPage += 1})
            }
            2 -> {
                Page2(
                    onButtonClick = {currentPage += 1})
            }
            3 -> {
                Page3(
                    onButtonClick = {currentPage += 1})
            }
        }
    }
}

@Composable
fun Page1(drawableResourceID: Int,
          contentDescriptionResourceId: Int,
          onButtonClick: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(drawableResourceID),
                contentDescription = stringResource(contentDescriptionResourceId),
                modifier = Modifier
                    .height(500.dp)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButtonClick) {
            Text(text = "Let's connect you!")
        }
    }
}

@Composable
fun Page2(
    onButtonClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Would you like to...",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onButtonClick) {
            Text(text = "GET FOOD")
        }
        Button(
            onClick = onButtonClick) { //user is sent to page 4
            Text(text = "GIVE FOOD")
        }
    }
}

@Composable
fun Page3(
    onButtonClick: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.prompt_user),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditLocationField()
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(id = R.string.help_user),
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun EditLocationField(){
    var locationInput by remember { mutableStateOf("") }
    TextField(
        value = locationInput,
        onValueChange = {locationInput = it},
        label = { Text(text = stringResource(id = R.string.directions)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Preview
@Composable
fun FoodworkPreview() {
    // A surface container using the 'background' color from the theme
    Foodwork()
}