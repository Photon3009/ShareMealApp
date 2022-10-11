package com.example.sharemeal.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sharemeal.R
import com.example.sharemeal.Screen
import com.example.sharemeal.ui.theme.ShareMealTheme

@Composable
fun Greeting(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.untitled_design_),
            contentDescription = null,
            modifier = Modifier.width(300.dp)
        )
        Text(text = "Welcome to Share Meal ", fontSize =30.sp)
       // Spacer(modifier = Modifier.height(16.dp))
        Text(text = "We always welcome donations and promise to use them to provide help to homeless people and animals! ",
            fontSize =18.sp, modifier = Modifier.padding(start = 16.dp,end=16.dp), textAlign = TextAlign.Justify)
        Spacer(modifier = Modifier.height(48.dp))
        Button(onClick = {navController.navigate(Screen.DRegisterScreen.route)},Modifier.fillMaxWidth(),
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(123, 167, 149,255)), )
        { Text(text = "Donate", color = Color.White)

        }
        Button(onClick = {navController.navigate(Screen.NRegisterScreen.route)},Modifier.fillMaxWidth(),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(123, 167, 149,255)))
        { Text(text = " NGOs ", color = Color.White)

        }


    }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShareMealTheme {
        Greeting(navController = rememberNavController())
    }
}